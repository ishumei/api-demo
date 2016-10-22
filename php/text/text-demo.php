<?php

require "../lib/httpclient.php";
use shumei\httpclient\SMCurl;
$mycurl = new SMCurl();
$mycurl->url = "http://api.fengkongcloud.com/v2/saas/anti_fraud/text";
//set your own accessKey
$postData = array("accessKey"=>"xxxxxxxxxxxxxxxxxxxx", "type"=>"ZHIBO", "data"=>array("tokenId"=>"tokenId_test", "text"=>"iphone 7")); 
$response = $mycurl->Post($postData);
print_r($response);
