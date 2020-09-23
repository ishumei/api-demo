import base64

import requests

url = 'http://api-audio-bj.fengkongcloud.com/audio/v4'
access_key = '{ACCESS_KEY}'
bt_id = '{BT_ID}'
filename = '../files/demo.pcm'

with open(filename, 'rb') as f:
    content = base64.b64encode(f.read())

payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'audio',
    'type': 'DEFAULT',
    'content': content.decode('utf-8'),
    'contentType': 'RAW',
    'btId': bt_id,
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'formatInfo': {
            'format': 'pcm',
            'rate': 8000,
            'track': 1,
        },
    },
}

res = requests.post(url, json=payload)
# 通过 code 和 riskLevel 判断返回，具体请参考接口文档
if res:
    print(res.json())
