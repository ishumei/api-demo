<?php

require "../lib/httpclient.php";
use shumei\httpclient\SMCurl;
$mycurl = new SMCurl();
$mycurl->url = "http://fp.fengkongcloud.com/v1/profile";
//set your own accessKey
$postData = array("organization"=>"xxxxxxxxxxxxxxxxxxxx", "data"=>array("fingerprint"=>"866657020185815", "sessionId"=>"1234567890")); 
$response = $mycurl->Post($postData);
print_r($response);
