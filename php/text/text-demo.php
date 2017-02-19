<?php

require "../lib/httpclient.php";
use shumei\httpclient\SMCurl;
$mycurl = new SMCurl();
$mycurl->url = "http://api.fengkongcloud.com/v2/saas/anti_fraud/text";
//set your own accessKey
$postData = array("accessKey"=>"xxxxxxxxxxxxxxxxxxxx", "type"=>"ZHIBO", "data"=>array("tokenId"=>"tokenId_test", "text"=>"iphone 7")); 
$response = $mycurl->Post($postData);
print_r($response);
$resJson = json_decode($response, true)
// success
if ($resJson["code"] == 1100) {
    if ($resJson["riskLevel"] == "PASS") {
        // 放行
    } else if ($resJson["riskLevel"] == "REVIEW") {
	    // 人工审核，如果没有审核，就放行
    } else if ($resJson["riskLevel"] == "REJECT") {
	    // 拒绝
    } else {
        // 异常
    }
}
