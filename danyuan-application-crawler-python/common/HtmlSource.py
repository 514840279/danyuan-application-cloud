#!/usr/bin/env python3
# -*- coding: UTF-8 -*-
# develop 514840279
#-----系统自带必备模块引用-----

import requests
import re #正则处理
import urllib
import chardet
from bs4 import BeautifulSoup as bs_4
from selenium import webdriver # 浏览器引擎webdriver模块
from lxml import etree
import os
from selenium.webdriver.chrome.options import Options 

# 获取网页源码 重要
class HtmlSource:

    requestConn=0

    def get_html(self,url_p, type_p='requestGet', chartset_p='utf-8',timeout_p=30):
        headers_p = {"User-Agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36"}
        txt = ""
        # 获取网页源码
        try:
            # get的方法
            if (type_p == 'requestGet'):
                html = requests.get(url=url_p, timeout=timeout_p, headers=headers_p)
                txt = str(html.text.encode(html.encoding), encoding=chartset_p)
                status_code = html.status_code
                html.close()

            # post的方法
            if (type_p == 'requestPost'):
                html = requests.post(url=url_p, timeout=timeout_p, headers=headers_p)
                txt = str(html.text.encode(html.encoding), encoding=chartset_p)
                status_code = html.status_code
                html.close()

            # session的方法
            elif (type_p == 'session'):
                res_addr = self.session.get(url_p, timeout=timeout_p, headers=headers_p)
                res_addr.encoding = chardet.detect(res_addr.content)["encoding"]
                txt = bs_4(res_addr.text, "lxml")

            # urllib的方法
            elif (type_p == 'urllib'):
                status_code,txt = self.get_html_ulib( url_p,  chartset_p=chartset_p)

            # Selenium的方法 待完善
            elif (type_p == 'chrome'):
                txt,driver =self.get_html_selenium(url_p)

        except(Exception):

            # TODO
            pass
        if(txt=="" and self.requestConn < 3):
            txt = self.get_html(url_p, type_p='requestGet', chartset_p='utf-8',timeout_p=30)
        return txt

    #  获取网页原文 （ulib）
    def get_html_ulib(self,url_p, chartset_p='utf-8'):
        html = urllib.request.urlopen(url=url_p)
        txt = html.read().decode(chartset_p)
        status_code = html.status_code
        html.close()
        return status_code,txt

    #  获取网页原文 （selenium）
    def get_html_selenium(self,url_p):
        driver = webdriver.Chrome("../driver/chromedriver.exe")
        driver.get(url_p)
        js = "document.documentElement.scrollTop=1000000"
        driver.execute_script(js)
        driver.implicitly_wait(30)  # 据说此方法是智能等待，看效果还不错，数据加载完就返回了 30 代表等待秒
        txt = driver.page_source
        return txt,driver

    # 获取网页字符集
    def get_encodings_from_content(self,content):
        charset = re.compile(r'<meta.*?charset=["\']*(.+?)["\'>]', flags=re.I).findall(content)
        if len(charset) == 0:
            charset = re.compile(r'<meta.*?content=["\']*;?charset=(.+?)["\'>]', flags=re.I).findall(content)
            if len(charset) == 0:
                charset = re.compile(r'^<\?xml.*?encoding=["\']*(.+?)["\'>]').findall(content)
                if len(charset) == 0:
                    charset = ['utf-8']
        return charset[0]

    # 获取html原码的地址列表信息1
    def get_url_list(self, html=''):
        all_a_url = re.findall("href=[\"'](.*?)[\"']", html)
        return all_a_url

    # 获取html原码的地址列表信息2
    def get_url_list_xpath(self, html=''):
        # print(html)
        # 取得列表块
        doc = etree.HTML(html)
        # 网页上所有a标签的href地址
        all_a_url = doc.xpath('//a/@href')
        # all_img_url = doc.xpath('//img/@src')[0]

        # 地址
        return all_a_url

    # 获取超链接内容
    def get_a_text(self, html=""):
        a_text_p = ()
        try:
            a_text_p = re.findall("href=[\"'](.*?)[\"'](.*?)>(.*?)</a>", html)
        except:
            pass
        return a_text_p

    # 去除噪点
    def addr_clear(self, all_a_url_p):
        list_url = []
        for url in all_a_url_p:
            # 先去除 噪点
            if "javascript" not in url and url.replace('#', '') != "":
                # 去除重复
                if url not in list_url:
                    list_url.append(url.strip())
        return list_url


    ####################################################
    ######  使用 addr_whole（）计算完整的url地址 #######
    ####################################################

    # 截取相对路径
    def current_url_get(self, url_p=""):
        url_t = ""
        if ("://" in url_p):
            url_t = url_p.split('://')[0]
            url_p = url_p.replace(url_t + "://", "")
            # 如果存在二级及以上的虚拟目录
            if ("/" in url_p):
                url_p = url_p.replace('/' + url_p.split('/')[-1], '/')
            url_p = url_t+"://"+url_p
        else:
            return url_t
        return url_p

    # 计算完整的路径
    def addr_reckon(self, url, url_root):
        first_charate = url[0:1]
        second_charate = url[1:2]
        # print(first_charate)
        if first_charate == '/':
            # 根路径拼接
            if second_charate == '/':
                url = url
            else:
                url_root_temp = self.get_url_root(url=url_root)
                url = url_root_temp + url

        elif first_charate == '.':
            if second_charate == '/':
                # 当前路径下拼接
                url = url_root + url[1:]
            elif second_charate == '.':
                # 递归上层路径
                url = url[3:]
                # print(url)
                current_url = self.current_url_get(url_p=url_root)
                # print(url_root)
                url = self.addr_reckon(url=url, url_root=current_url)
        elif '//' in url:
            url = '//' + url.split('//')[1]
        elif ':' in url:
            url = '//' + url.split(':')[1]
        elif url[0:1] in ['?', '~', '+']:
            url = url
        if (url[0:5] == "http:" and url[0:7] != "http://"):
            url = url[0:5] + "//" + url[6:len(url)]
        elif(url[0:5] == "https:" and url[0:7] != "https://"):
            url = url[0:6] + "//" + url[7:len(url)]
        elif(url[0:2] =="//"):
            if('http:'in url_root or 'https:' in url_root):
                https = url_root.split(":")[0]
            url = https+url

        return url

    # 读取网站域名
    def get_url_root(self, url):
        http = ''
        https = ''
        if 'http://' in url or 'http:/' in url:
            http = 'http://'
            url = url.replace('http://', '').replace('http:/', '').strip()
        elif 'https://' in url or 'https:/' in url:
            https = 'https://'
            url = url.replace('https://', '').replace('httpss:/', '').strip()
        else:
            pass
        url_root = url.split('/')[0]
        return (http + https + url_root)

    # 补全完整路径/
    def addr_whole(self, all_a_url, url_root):
        url_temp = []
        current_url = self.current_url_get(url_p=url_root)
        for url in all_a_url:
            if "http" not in url:
                # 计算完整路径
                url = self.addr_reckon(url, url_root=current_url)
            # 简单验证地址的正确性
            if self.addr_validate(url=url):
                url_temp.append(url.strip())
        all_a_url = url_temp
        return all_a_url


    # 简单验证地址的正确性
    def addr_validate(self,url=''):
        url_head = url.split(':')[0]
        if url_head not in ['http','https','ftp']:
            if url[0:2] == '//':
                return True
            if url[0:1] == '/':
                return True
            return False
        else:
            return True

    #########################################################

    def main(self):
        print("")

if __name__ == '__main__':
    print("")