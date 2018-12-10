#!/usr/bin/python3
import json
from flask import Response,Blueprint
from controller.service.CrawlerService import CrawlerService
# 使用 蓝图 定义 模块，
crawler = Blueprint(name='crawler',import_name="crawler" ,static_folder='./static',template_folder='./templates')

searchUrlListKey= [{
                'name': '360',
                'searchSrc': 'https://www.so.com/s?ie=utf-8&shb=1&src=360sou_newhome&q='
            },{
                'name': 'baidu',
                'searchSrc': 'https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd='
            },{
                'name': 'sougou',
                'searchSrc': 'https://www.sogou.com/web?query='
            }]

# 提供健康检查用接口
@crawler.route("/<type>/<keyword>",methods=['POST'])
def search(type,keyword):
    result = {"code":1}
    for url in searchUrlListKey:
        print(url)
        if (url['name']==type):
            searchUrl = url['searchSrc']+keyword
            crawlerService = CrawlerService()
            crawlerService.crawler(searchUrl=searchUrl,keyword=keyword,plant=type)

    return Response(json.dumps(result), mimetype='application/json') # 采用json方式发送数据


