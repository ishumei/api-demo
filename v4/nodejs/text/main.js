const utils = require('../lib/utils')

const url = 'http://api-text-bj.fengkongcloud.com/text/v4'
const access_key = '{ACCESS_KEY}'
const text = '{TEXT}'
const uid = '{UID}'

const payload = {
    'accessKey': access_key,
    'appId': 'default',
    'eventId': 'default',
    'type': 'ALL',
    'data': {
        'text': text,
        'tokenId': uid,
    }
}

utils.sendRequest(url, 'POST', payload, data => {
    console.log(data)
})