const utils = require('../lib/utils')

const url = 'http://api-text-bj.fengkongcloud.com/v2/saas/anti_fraud/text'
const access_key = '{ACCESS_KEY}'
const text = '{TEXT}'
const uid = '{UID}'

const payload = {
    'accessKey': access_key,
    'type': 'SOCIAL',
    'appId': 'default',
    'data': {
        'text': text,
        'tokenId': uid,
    }
}

utils.sendRequest(url, 'POST', payload, data => {
    console.log(data)
})