<?php
require "../lib/httpclient.php";
use shumei\httpclient\SMCurl;
$mycurl = new SMCurl();
$mycurl->url = "http://api.fengkongcloud.com/v2/saas/anti_fraud/img";
//get image(please set your image path)
$imgContent = file_get_contents("./demo.jpg");
$imgStr = base64_encode($imgContent);
//set your own accessKey
$postData = array("accessKey"=>"xxxxxxxxxxxxxxxxxxxx", "type"=>"AD", "data"=>array("tokenId"=>"tokenId_test", "img"=>$imgStr)); 
$response = $mycurl->Post($postData);
print_r($response);
