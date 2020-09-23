import requests
import time

url = 'http://api-skynet-bj.fengkongcloud.com/v3/event'
access_key = '{ACCESS_KEY}'
event_id = 'register'

payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': event_id,
    'data': {
        'tokenId': '{UID}',
        'ip': '127.0.0.1',
        'timestamp': int(time.time() * 1000),
    }
}

res = requests.post(url, json=payload)
# 通过 code 和 riskLevel 判断返回，具体请参考接口文档
if res:
    print(res.json())
