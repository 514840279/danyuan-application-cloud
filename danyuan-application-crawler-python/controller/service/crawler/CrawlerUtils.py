#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import hashlib

class CrawlerUtils():


    # 计算MD5值
    def get_md5_value(self,src):
        myMd5 = hashlib.md5()
        myMd5.update(src.encode("utf8"))
        myMd5_Digest = myMd5.hexdigest()
        return myMd5_Digest


    def __init__(self):
        pass

    if __name__ == '__main__':
        pass