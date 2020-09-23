import base64

import requests

url = 'http://api-img-bj.fengkongcloud.com/image/v4'
access_key = '{ACCESS_KEY}'
uid = '{UID}'
filename = '../files/demo.png'

with open(filename, 'rb') as f:
    content = base64.b64encode(f.read())

payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'default',
    'type': 'DEFAULT',
    'data': {
        'img': content.decode('utf-8'),
        'tokenId': uid,
    }
}

res = requests.post(url, json=payload)
# 通过 code 和 riskLevel 判断返回，具体请参考接口文档
if res:
    print(res.json())
