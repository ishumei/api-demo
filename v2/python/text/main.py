import requests

url = 'http://api-text-bj.fengkongcloud.com/v2/saas/anti_fraud/text'
access_key = '{ACCESS_KEY}'
text = '{TEXT}'
uid = '{UID}'

payload = {
    'accessKey': access_key,
    'type': 'SOCIAL',
    'appId': 'default',
    'eventId': 'default',
    'data': {
        'text': text,
        'tokenId': uid,
    }
}

res = requests.post(url, json=payload)
# 通过 code 和 riskLevel 判断返回，具体请参考接口文档
if res:
    print(res.json())
