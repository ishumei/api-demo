const utils = require('../lib/utils')
const fs = require('fs')

const url = 'http://api-audio-sh.fengkongcloud.com/audiomessage/v4'
const access_key = '{ACCESS_KEY}'
const bt_id = '{BT_ID}'
const filename = '../files/demo.pcm'

const content = fs.readFileSync(filename, {encoding: 'base64'})
const payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'audio',
    'type': 'POLITY_EROTIC_MOAN_ADVERT',
    'content': content,
    'contentType': 'RAW',
    'btId': bt_id,
    'callback': 'https://jsonplaceholder.typicode.com/posts/',
    'data': {
        'format': 'pcm',
        'rate': 8000,
        'track': 1,
    },
}

utils.sendRequest(url, 'POST', payload, data => {
    // 通过 code 和 riskLevel 判断返回，具体请参考接口文档
    console.log(data)
})