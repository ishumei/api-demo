<?php

require 'lib/utils.php';

$url = 'http://api-skynet-bj.fengkongcloud.com/v3/event';
$access_key = '{ACCESS_KEY}';
$event_id = 'register';

$payload = array(
    'accessKey' => $access_key,
    'appId' => 'default',
    'eventId' => $event_id,
    'data' => array(
        'tokenId' => '{UID}',
        'ip' => '127.0.0.1',
        'timestamp' => time() * 1000,
    ),
);

$res = request_post($url, json_encode($payload));
$data = json_decode($res);
// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
var_dump($data);
