#!/usr/bin/python3
import json
from flask import Response,Blueprint
from flask import request
from controller.service.NavigationService import  NavigationService
from common.DateEncoder import DateEncoder
# 使用 蓝图 定义 模块，
navigation  = Blueprint(name='navigation',import_name="navigation" ,static_folder='./static',template_folder='./templates')


# 查询列表信息
@navigation.route("/findAll",methods=['POST'])
def findAll():
    params = request.json
    navigationService =  NavigationService()
    data = navigationService.findAll(page_number=1,page_size=10,params=params)
    return Response(json.dumps(data,cls=DateEncoder), mimetype='application/json') # 采用json方式发送数据

# 查询列表信息
@navigation.route("/findAllByName",methods=['POST'])
def findAllByName():
    params = request.json
    navigationService =  NavigationService()
    data = navigationService.findAllByName(page_number=1,page_size=10,params=params)
    return Response(json.dumps(data,cls=DateEncoder), mimetype='application/json') # 采用json方式发送数据

# 查询组
@navigation.route("/findGroupList",methods=['POST','GET'])
def findGroupList():
    navigationService =  NavigationService()
    data = navigationService.findGroupList()
    return Response(json.dumps(data), mimetype='application/json') # 采用json方式发送数据

# 查询组
@navigation.route("/findTypeList",methods=['POST'])
def findTypeList():
    params = request.json
    navigationService =  NavigationService()
    data = navigationService.findTypeList(params['group'])
    return Response(json.dumps(data), mimetype='application/json') # 采用json方式发送数据

# 查询组
@navigation.route("/findOne",methods=['POST'])
def findOne():
    params = request.json
    navigationService =  NavigationService()
    data = navigationService.findOne(params['uuid'])
    return Response(json.dumps(data[0],cls=DateEncoder), mimetype='application/json') # 采用json方式发送数据

# 点赞
@navigation.route("/updatePraise",methods=['POST'])
def updatePraise():
    params = request.json
    navigationService =  NavigationService()
    navigationService.updatePraise(params['uuid'])
    return Response(json.dumps({'code':200}), mimetype='application/json') # 采用json方式发送数据

