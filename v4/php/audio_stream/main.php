<?php

require 'lib/utils.php';

$url = 'http://api-audiostream-bj.fengkongcloud.com/audiostream/v4';
$access_key = '{ACCESS_KEY}';
$stream_url = '{URL}';
$bt_id = '{BT_ID}';
$uid = '{UID}';

$payload = array(
    'accessKey' => $access_key,
    'appId' => 'default',
    'eventId' => 'audio',
    'type' => 'DEFAULT',
    'btId' => $bt_id,
    'callback' => 'https://jsonplaceholder.typicode.com/posts/',
    'data' => array(
        'url' => $stream_url,
        'tokenId' => $uid,
    ),
);

$res = request_post($url, json_encode($payload));
$data = json_decode($res);
// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
var_dump($data);