<?php

require 'lib/utils.php';

$url = 'http://api-videostream-bj.fengkongcloud.com/v3/saas/anti_fraud/videostream';
$access_key = '{ACCESS_KEY}';
$uid = '{UID}';
$video_url = 'https://jsonplaceholder.typicode.com/posts/';

$payload = array(
    'accessKey' => $access_key,
    'appId' => 'default',
    'imgType' => 'POLITICS_PORN_AD',
    'audioType' => 'NONE',
    'imgCallback' => 'https://jsonplaceholder.typicode.com/posts/',
    'data' => array(
        'streamType' => 'NORMAL',
        'tokenId' => $uid,
        'url' => $video_url,
    ),
);

$res = request_post($url, json_encode($payload));
$data = json_decode($res);
// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
var_dump($data);
