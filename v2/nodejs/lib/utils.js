const http = require('https')
const urlutil = require('url')

/**
 * 发送请求
 * @param {*} url 请求地址
 * @param {*} type 请求类型
 * @param {*} postData 请求数据
 * @param {*} callback 回调函数
 */
function sendRequest(url, type, postData, callback) {
    const content = JSON.stringify(postData)
    const urlObj = urlutil.parse(url)
    const options = {
        hostname: urlObj.host,
        port: urlObj.port,
        path: urlObj.path,
        method: type,
        headers: {
            'Content-Type': 'Content-Type: application/json; charset=utf-8',
            'Content-Length': Buffer.byteLength(content)
        }
    }
    let responseData = ''
    const req = http.request(options, function (res) {
        res.setEncoding('utf8')

        res.on('data', function (chunk) {
            responseData += chunk
        })
        res.on('end', function () {
            callback(JSON.parse(responseData))
        })
        req.on('error', function (e) {
            console.log('request ERROR: ' + e.message)
        })

        req.setTimeout(1000, function () {
            console.log('request timeout!')
            req.abort()
        })
    })
    req.write(content)
    req.end()
}

exports.sendRequest = sendRequest