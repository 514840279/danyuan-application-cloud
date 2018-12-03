#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import json
#import os
from flask import Flask, Response,render_template
# 引入 模块
from controller.Search import dosearch as search_blueprinit
from controller.Crawler import crawler as crawler_blueprinit
from controller.Navigation import navigation as navigation_blueprinit
from controller.StartController import start as start_blueprinit
# BASE_DIR建立一个基础路径，用于静态文件static，templates的调用
#BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

app=Flask(__name__,template_folder='templates',static_folder='static')

# 使用 蓝图 注册不同模块
app.register_blueprint(crawler_blueprinit,url_prefix='/crawler')
app.register_blueprint(search_blueprinit,url_prefix='/search')
app.register_blueprint(navigation_blueprinit,url_prefix='/nivigation')
app.register_blueprint(start_blueprinit,url_prefix='/start')


# 当访问 "/"，"/index"，"/home","incex.hltml" 默认跳转到 "/index.hmtl" 模板中渲染首页
@app.route("/")
@app.route("/home")
@app.route("/index")
@app.route("/index.html")
def findhell():
    result = {'username': 'python', 'password': 'python'}
    return render_template('index.html', name=result) # 采用模板方式解析页面


if __name__ == '__main__':
    uuid='68103c87-e974-46e2-bf54-a3c1b817ab41'
    print(uuid)

# 提供健康检查用接口
@app.route("/health")
def health():
    result = {'status': 'UP'}
    return Response(json.dumps(result), mimetype='application/json') # 采用json方式发送数据


# 测试接口
@app.route("/test")
def getUser():
    result = {'username': 'python', 'password': 'python'}
    return Response(json.dumps(result), mimetype='application/json')


######################################
#           错误控制中心             #
######################################
# 统一错误返回配置方法
def Response_headers(content):
    resp = Response(content)
    resp.headers['Access-Control-Allow-Origin'] = '*'
    return resp

@app.errorhandler(403)
def page_not_found(error):
    content = json.dumps({"error_code": "403"})
    resp = Response_headers(content)
    return resp

@app.errorhandler(404) 
def page_not_found(error): 
    content = json.dumps({"error_code": "404"})
    resp = Response_headers(content)
    return resp

@app.errorhandler(400) 
def page_not_found(error): 
    content = json.dumps({"error_code": "400"})
    # resp = Response(content)
    # resp.headers['Access-Control-Allow-Origin'] = '*'
    resp = Response_headers(content)
    return resp
    # return "error_code:400"

@app.errorhandler(410) 
def page_not_found(error): 
    content = json.dumps({"error_code": "410"})
    resp = Response_headers(content)
    return resp

@app.errorhandler(500) 
def page_not_found(error):
    content = json.dumps({"error_code": "500"})
    resp = Response_headers(content)
    return resp


app.run(port=3000, host='0.0.0.0')