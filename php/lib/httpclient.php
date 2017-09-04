<?php 
namespace shumei\httpclient;

class SMCurl {
    public $url = "";
    public $connectTime = 2;
    public $timeout = 5;
    public function Get() {
        //初始化
        $ch = curl_init();
        //设置选项，包括URL
        curl_setopt($ch, CURLOPT_URL, $this->url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_HEADER, 0);
        //执行并获取HTML文档内容
        $output = curl_exec($ch);
        //释放curl句柄
        curl_close($ch);
        //返回结果
        return $output;
    }
    public function Post($postData) {
        $data_string = json_encode($postData);
        $ch = curl_init();
        // 设置超时时间
        curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, $this->connectTime);
        curl_setopt($ch, CURLOPT_TIMEOUT, $this->timeout);

        curl_setopt($ch, CURLOPT_URL, $this->url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        // post数据
        curl_setopt($ch, CURLOPT_POST, 1);
        // post的变量
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data_string);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json; charset=utf-8', 'Content-Length: ' . strlen($data_string)));  
        $output = curl_exec($ch);
        curl_close($ch);
        //返回结果
        return $output;
    }
}
