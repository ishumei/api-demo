<?php

require 'lib/utils.php';

$url = 'http://api-audio-bj.fengkongcloud.com/v2/saas/anti_fraud/audio';
$access_key = '{ACCESS_KEY}';
$bt_id = '{BT_ID}';
$filename = '../files/demo.pcm';

$payload = array(
    'accessKey' => $access_key,
    'type' => 'DEFAULT',
    'appId' => 'default',
    'btId' => $bt_id,
    'callback' => 'https://jsonplaceholder.typicode.com/posts/',
    'data' => array(
        // url 和 content 至少提供一个
        // 'url' => 'https://jsonplaceholder.typicode.com/audio',
        'content' => base64_encode(file_get_contents($filename)),
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
