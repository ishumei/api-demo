<?php

require 'lib/utils.php';

$url = 'http://api-video-bj.fengkongcloud.com/v2/saas/anti_fraud/video';
$access_key = '{ACCESS_KEY}';
$video_url = 'https://jsonplaceholder.typicode.com/posts/';
$bt_id = '{BT_ID}';

$payload = array(
    'accessKey' => $access_key,
    'imgType' => 'POLITICS_PORN_AD',
    'audioType' => 'NONE',
    'appId' => 'default',
    'btId' => $bt_id,
    'callback' => 'https://jsonplaceholder.typicode.com/posts/',
    'data' => array(
        'url' => $video_url,
    ),
);

$res = request_post($url, json_encode($payload));
$data = json_decode($res);
// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
var_dump($data);
