const utils = require('../lib/utils')

const url = 'http://api-audiostream-bj.fengkongcloud.com/audiostream/v4'
const access_key = '{ACCESS_KEY}'
const stream_url = '{URL}'
const bt_id = '{BT_ID}'
const uid = '{UID}'

const payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'audio',
    'type': 'DEFAULT',
    'btId': bt_id,
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'url': stream_url,
        'tokenId': uid,
    }
}

utils.sendRequest(url, 'POST', payload, data => {
    // 通过 code 和 riskLevel 判断返回，具体请参考接口文档
    console.log(data)
})