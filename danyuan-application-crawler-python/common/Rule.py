#!/usr/bin/env python3
# -*- coding: UTF-8 -*-

from lxml import html
from lxml import etree
from common import HtmlSource

class Rule:

    # 解析页面
    def _analysis_(self,tree ,column):
        column_context = []
        # column_context = [("md5", [md5])]
        # column_context.append(("标题链接", [url]))
        for a in column:

            if 'lxml' == a['type']:
                # 进行lxml方式解析
                text = tree.xpath(a['ruler'])
                column_context.append((a['colum_name'], text))
            elif 'none' == a['type']:
                # 返回 做补位处理
                column_context.append((a['colum_name'], [a['ruler']]))
            elif 'sp' == a['type']:
                # 二次处理
                text = tree.xpath(a['ruler'])
                print(text)
                if len(text) > 0:
                    column_context.append((a['colum_name'], [(text[0].split(a[3])[a[4]]).strip()]))
                else:
                    column_context.append((a['colum_name'], []))
            elif 'strAppendbefor' == a['type']:
                # 二次处理 字符串前拼接
                # 赶集网读取联系电话完整图片地址 处理过程
                text = tree.xpath(a['ruler'])
                list = []
                for path in text:
                    list.append(a['param'] + path.strip())
                column_context.append((a['colum_name'], list))
            elif 'arr' == a['type']:
                # 二次处理 几个中的一个
                text = tree.xpath(a['ruler'])
                column_context.append((a['colum_name'], text[a['start']].strip()))
            elif 'sarr' == a['type']:
                # 二次处理 几个中的和成一个
                text = tree.xpath(a['ruler'])
                st = ''
                for item in text:
                    # print(item)
                    if item.strip() == '':
                        pass
                    else:
                        st = st + item.strip()
                column_context.append((a['colum_name'], [st.strip()]))
            elif 'sarra' == a['type']:
                # 二次处理 几个中的和成一个
                text = tree.xpath(a['ruler'])
                st = ''
                for item in text:
                    # print(item)
                    if item.strip() == '':
                        pass
                    else:
                        st = st + item.strip() + a['param']
                column_context.append((a['colum_name'], [st.strip()]))
            elif 'nsp' == a['type']:
                # 二次处理 非固定列 ul处理
                # 应届生网最后的不固定信息
                text = tree.xpath(a['ruler'])
                list = []
                column = []
                for item in text:
                    print(item)
                    if item.strip() == '':
                        pass
                    else:
                        list.append(item.strip())
                for item in range(len(list)):
                    if item % 2 == 1:
                        column.append((list[item - 1], [list[item]]))
                column_context.append((a['colum_name'], column))
            elif 'nspa' == a['type']:
                # 二次处理 非固定列 ul处理
                # 拉钩网企业信息不固定
                text = tree.xpath(a['ruler'])
                list = []
                column = []
                for item in text:
                    print(item)
                    if item.strip() == '':
                        pass
                    else:
                        list.append(item.strip())
                for item in range(len(list)):
                    if item % 2 == 1:
                        column.append(([list[item]], list[item - 1]))
                column_context.append((a['colum_name'], column))
        return column_context

    # 数据提取详细页的
    def html_content_analysis_detial(self,html_text,group_ruler, column):
        tree = html.fromstring(html_text)
        content = tree.xpath(group_ruler)
        column_context = self._analysis_(tree=content,column=column)
        print(column_context)
        return column_context

    # 数据提取列表页处理方式
    def html_content_analysis_list(self,html_text,group, column):
        tree = html.fromstring(html_text)
        content = tree.xpath(group['ruler'])[0]
        column_content = content.xpath(group['items_ruler'])
        print(group['nextpage_ruler'])
        nextpage = content.xpath(group['nextpage_ruler'])
        #htmlsource = HtmlSource()
        #nextpage = htmlsource.addr_reckon(nextpage)
        lista = []
        for a in range(len(column_content)):
            row = self._analysis_(tree=column_content[a], column=column)
            lista.append(row)
        print(lista)
        return lista,nextpage

    # 数据提取列表页处理方式
    def html_content_analysis_navigation(self,html_text,group_ruler, column):
        tree = html.fromstring(html_text)
        column_content = tree.xpath(group_ruler)
        lista=[]
        for a in range(len(column_content)):
            row = self._analysis_(tree=column_content[a],column=column)
            lista.append(row)
        print(lista)
        return lista