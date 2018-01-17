var utils = require('../lib/utils');
var config = require('../lib/config');
//上传数据
var postData = {
    accessKey: config.SM_ACCESSKEY,
    type: 'ZHIBO'
};
//请求地址
var url = config.SM_API_HOST+config.TEXT_URI;
//需要上传的数据
var dataParams = {
    tokenId: "tokenId_test",
    text: "需要的加违心：qianqianwoaini77520 各种全新正品手机低价售"
};
postData['data'] = dataParams;

//发送请求
utils.sendRequest(url, "POST", postData, function(data) {
    var result = JSON.parse(data);

    if(result.code == "1100") {
        switch(result.riskLevel) {
            case "PASS":
                // 放行
                console.log('放行');
                break;
            case "REJECT":
                // 拒绝
                console.log('拒绝');
                break;
            case "REVIEW":
                // 人工审核，如果没有审核，就放行
                console.log('人工审核或者通过或者拒绝');
                break;
            default:
                // 异常
                console.log('出现异常');
                break;
        }
    }else {
        // 接口请求失败，需要参照返回码进行不同的处理
        console.log(result);
    }
});
