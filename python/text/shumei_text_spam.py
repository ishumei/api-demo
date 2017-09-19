#!/usr/bin/env python
# -*- coding: utf-8 -*-

import requests
import base64
import hashlib
import os
import json
import sys
import time

def shumei_text_spam(text, timeout):
    data = {"text": text, "tokenId": "12345678"}
    playload = {"accessKey": "XXXXXXXXXXX", "type": "ZHIBO", "data": data}
    body = json.dumps(playload)
    shumei_url = "http://api.fengkongcloud.com/v2/saas/anti_fraud/text"
    shumei_result = requests.post(shumei_url, data=body, timeout=timeout)
    encode_result = json.loads(shumei_result.text)
    if (encode_result["code"] == 1100):
        print(encode_result)
    elif (encode_result["code"] == 1902):
        # 参数不合法
        print(encode_result)
    elif (encode_result["code"] == 1903):
        # 服务失败
        print(encode_result)
    elif (encode_result["code"] == 9100):
        # 余额不足
        print(encode_result)
    elif (encode_result["code"] == 9101):
        # 无权限操作
        print(encode_result)
    else: 
        # 不明错误
        pass

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: shumei_text_spam <timeout> <text>")
        exit(1)
    request_timeout = float(sys.argv[1])
    text = sys.argv[2]
    shumei_text_spam(text, request_timeout)
