<?php

require 'lib/utils.php';

$url = 'http://api-audio-bj.fengkongcloud.com/audio/v4';
$access_key = '{ACCESS_KEY}';
$bt_id = '{BT_ID}';
$filename = '../files/demo.pcm';

$payload = array(
    'accessKey' => $access_key,
    'appId' => 'default',
    'eventId' => 'audio',
    'type' => 'DEFAULT',
    'contentType' => 'RAW',
    'content' => base64_encode(file_get_contents($filename)),
    'btId' => $bt_id,
    'callback' => 'https://jsonplaceholder.typicode.com/posts/',
    'data' => array(
        'formatInfo' => array(
            'format' => 'pcm',
            'rate' => 8000,
            'track' => 1,
        ),
    ),
);

$res = request_post($url, json_encode($payload));
$data = json_decode($res);
// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
var_dump($data);