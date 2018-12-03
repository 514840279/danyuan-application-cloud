#!/usr/bin/python3
import json
from flask import Response,Blueprint
from flask import request
from controller.service.StartService import  StartService
# 使用 蓝图 定义 模块，
start = Blueprint(name='start',import_name="start" ,static_folder='./static',template_folder='./templates')


@start.route("/run",methods=['POST'])
def run():
    params = request.json
    startService = StartService()
    for item in params['list']:
        startService.run(item)
    return Response("1", mimetype='application/json')  # 采用json方式发送数据