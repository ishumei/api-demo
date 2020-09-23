var http = require('https');
var urlutil=require('url');
/**
 * 发送请求
 * @param {*} url 请求地址
 * @param {*} type 请求类型
 * @param {*} postData 请求数据
 * @param {*} callback 回调函数
 */
function sendRequest(url, type, postData, callback) {
    var content = JSON.stringify(postData);
    var urlObj = urlutil.parse(url);
    var host = urlObj.hostname;
    var path = urlObj.path;
    var port = urlObj.port;
    var options = {
        hostname: host,
        port: port,
        path: path,
        method: type,
        headers: {
            'Content-Type': 'Content-Type: application/json; charset=utf-8',
            'Content-Length': Buffer.byteLength(content)
        }
    };
    var responseData = "";
    var req = http.request(options, function (res) {
        res.setEncoding('utf8');
        res.on('data', function (chunk) {
            responseData+=chunk;
        });
        res.on('end', function () {
            callback(responseData);
        });
        //设置超时
        req.setTimeout(1000,function(){
            console.log('request timeout!');
            req.abort();
        });
        req.on('error', function (e) {
            console.log('request ERROR: ' + e.message);
        });
    });
    req.write(content);
    req.end();
}

exports.sendRequest = sendRequest;