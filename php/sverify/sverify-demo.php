<?php
define('ROOT_PATH', dirname(dirname(__FILE__)));

require ROOT_PATH . "/lib/httpclient.php";
require ROOT_PATH . "/config.php";

use shumei\httpclient\SMCurl;

/**
 * 按照接口参数组装请求数据
 * 需要注意 data 参数，本身是个数组形式
 */
$postData['accessKey'] = SM_ACCESSKEY; 

$dataParams = array();
$dataParams['rid'] = '2017070721503647d7848a736d488a05'; // 设置rid,滑动验证请求标识 
$dataParams['ip'] = '123.34.56.65'; // 设置用户滑动验证码时的 ip
$dataParams['tokenId'] = 'tokenId_test'; // 设置tokenId, 由客户提供
$dataParams['deviceId'] = 'WHJMrwNw1k\/HaD1jpSlstRtDivohPNVX8saAw4+PdrHDDYiQrKp\/QC\/IHiUJ8adCu4xHU8XM5zg\/2Rmqmz150DolunjnW4Kyp\/xbAlu1JcB4dKRdXNWj9LZSD3EmPbcN1IeS8tJJ7gZlaOUjiL13hSwc5Gk51PvykdoQIOHWifdss2XCz7TYW1xB34ewlnDd\/V10I6KoHJT7NtAKvckCXn6cr5ZgXB6SsNT4\/WYB3NX63GEtjL0T2uNwuOXG+4ocFQ2C5nbwxLKYXXT+s9g2g3A==1487582755342'; // 设置deviceId, 由客户提供

$postData['data'] = $dataParams;

$mycurl = new SMCurl();
$mycurl->url = SM_CAPTCHA_HOST . SVERIFY_URI; // 设置请求url地址

$response = $mycurl->Post($postData); // 发起接口请求
print_r($response);
$resJson = json_decode($response, true);

/**
 * 接口会返回code， code=1100 时说明请求成功，根据不同的 riskLevel 风险级别进行业务处理  
 * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
 * 其余情况需要根据错误码进行重试或者其它异常处理
 */
if ($resJson["code"] == 1100) {
    if ($resJson["riskLevel"] == "PASS") {
        // 放行
    } else if ($resJson["riskLevel"] == "REJECT") {
	    // 拒绝
    } else {
        // 异常
    }
} else {
    // 接口请求失败，需要参照返回码进行不同的处理
}
