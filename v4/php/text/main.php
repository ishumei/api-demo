<?php

require 'lib/utils.php';

$url = 'http://api-text-bj.fengkongcloud.com/text/v4';
$access_key = '{ACCESS_KEY}';
$text = '{TEXT}';
$uid = '{UID}';

$payload = array(
    'accessKey' => $access_key,
    'appId' => 'default',
    'eventId' => 'default',
    'type' => 'ALL',
    'data' => array(
        'text' => $text,
        'tokenId' => $uid,
    ),
);

$res = request_post($url, json_encode($payload));
$data = json_decode($res);
// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
var_dump($data);