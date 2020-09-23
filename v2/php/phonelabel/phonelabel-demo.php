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
$dataParams['phone'] = '18687082306'; // 设置 phone 参数，手机号 

$postData['data'] = $dataParams;

$mycurl = new SMCurl();
$mycurl->url = SM_FINANCE_HOST . FINANCE_LABEL_URI; // 设置请求url地址
$response = $mycurl->Post($postData); // 发起接口请求
$resJson = json_decode($response, true);

/**
 * 接口会返回code， code=1100 时说明请求成功  
 * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
 * 其余情况需要根据错误码进行重试或者其它异常处理
 */
if ($resJson["code"] == 1100) {
    // 成功业务处理
    echo "request success\n";
    print_r($response);
} else {
    // 接口请求失败，需要参照返回码进行不同的处理
}
