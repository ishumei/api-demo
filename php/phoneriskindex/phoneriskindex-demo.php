<?php

require "../lib/httpclient.php";
use shumei\httpclient\SMCurl;
$mycurl = new SMCurl();
$mycurl->url = "https://finance-api.fengkongcloud.com/v2/finance/malagent";
//set your own accessKey
$postData = array("accessKey"=>"4Ky6AV4hE0pWLeG1bXNw","data"=>array("phone"=>"18687082306","imei"=>"352625061818645","records"=>array(array("phone"=>"18612292507","type"=>0,"startTime"=>1477050308,"duratioin"=>100)),"contacts"=>array(array("phone"=>"1868988703","name"=>"大志")))); 
$response = $mycurl->Post($postData);
print_r($response);
