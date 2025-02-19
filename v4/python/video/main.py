import requests

url = 'http://api-video-bj.fengkongcloud.com/video/v4'
access_key = '{ACCESS_KEY}'
bt_id = '{BT_ID}'
tokenId = '{Token_Id}'
video_url = 'https://jsonplaceholder.typicode.com/posts/'

payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'video',
    'imgType': 'POLITY_QRCODE_ADVERT',
    'audioType': 'POLITY_EROTIC',
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'url': video_url,
        'btId': bt_id,
        'tokenId': tokenId,
    },
}

res = requests.post(url, json=payload)
# 通过 code 和 riskLevel 判断返回，具体请参考接口文档
if res:
    print(res.json())
