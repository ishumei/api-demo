<?php

require "../lib/httpclient.php";
use shumei\httpclient\SMCurl;
$mycurl = new SMCurl();
$mycurl->url = "https://finance-api.fengkongcloud.com/v2/finance/labels";
//set your own accessKey
$postData = array("accessKey"=>"xxxxxxxxxxxxxxxxxxxx","data"=>array("phone"=>"18687082306")); 
$response = $mycurl->Post($postData);
print_r($response);
