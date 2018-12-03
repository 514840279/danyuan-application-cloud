#!/usr/bin/env python3
# -*- coding: UTF-8 -*-
# develop 514840279
#-----系统自带必备模块引用-----
import json
import datetime

class DateEncoder(json.JSONEncoder):  
    def default(self, obj):  
        if isinstance(obj, datetime.datetime):  
            return obj.strftime('%Y-%m-%d %H:%M:%S')  
        elif isinstance(obj, datetime.date):
            return obj.strftime("%Y-%m-%d")  
        else:  
            return json.JSONEncoder.default(self, obj) 
