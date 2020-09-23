import requests

url = 'http://api-audiostream-bj.fengkongcloud.com/v2/saas/anti_fraud/audiostream'
access_key = '{ACCESS_KEY}'
stream_url = '{URL}'
bt_id = '{BT_ID}'
uid = '{UID}'

payload = {
    'accessKey': access_key,
    'type': 'DEFAULT',
    'appId': 'default',
    'btId': bt_id,
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'url': stream_url,
        'tokenId': uid,
    }
}

res = requests.post(url, json=payload)
# 通过 code 和 riskLevel 判断返回，具体请参考接口文档
if res:
    print(res.json())
