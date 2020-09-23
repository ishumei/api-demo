const utils = require('../lib/utils')

const url = 'http://api-video-bj.fengkongcloud.com/video/v4'
const access_key = '{ACCESS_KEY}'
const bt_id = '{BT_ID}'
const video_url = 'https://jsonplaceholder.typicode.com/posts/'

const payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'video',
    'imgType': 'POLITICS_PORN_AD',
    'audioType': 'POLITICS_PORN_AD',
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'url': video_url,
        'streamType': 'NORMAL',
        'btId': bt_id,
    },
}

utils.sendRequest(url, 'POST', payload, data => {
    // 通过 code 和 riskLevel 判断返回，具体请参考接口文档
    console.log(data)
})