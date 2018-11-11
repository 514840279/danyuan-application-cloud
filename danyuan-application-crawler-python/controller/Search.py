#!/usr/bin/python3
import json
from flask import Response,Blueprint
from controller.service.SearchService import  SearchService
# 使用 蓝图 定义 模块，
dosearch = Blueprint(name='dosearch',import_name="dosearch" ,static_folder='./static',template_folder='./templates')


# 提供健康检查用接口
@dosearch.route("/<type>/<keyword>",methods=['POST'])
def search(type,keyword):
    result = {'type': 'keyword'}
    searchService =  SearchService()
    data = searchService.findAll(page_number=1,page_size=10,search_keyword=keyword,search_plant=type)
    print(data)
    return Response(json.dumps(data), mimetype='application/json') # 采用json方式发送数据