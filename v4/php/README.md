## 示例代码说明

请求前注意替换示例中的 Access Key，文件名及调用参数等相关信息。

```shell script
php text/main.php
```

返回输出：
```text
object(stdClass)#1 (11) {
  ["code"]=>
  int(1100)
  ["message"]=>
  string(6) "成功"
  ["requestId"]=>
  string(32) "434a81853d70262f3241fa41c5a15192"
  ["riskLevel"]=>
  string(4) "PASS"
  ["riskLabel1"]=>
  string(6) "normal"
  ["riskLabel2"]=>
  string(0) ""
  ["riskLabel3"]=>
  string(0) ""
  ["riskDescription"]=>
  string(6) "正常"
  ["riskDetail"]=>
  object(stdClass)#2 (0) {
  }
  ["allLabels"]=>
  array(0) {
  }
  ["auxInfo"]=>
  object(stdClass)#3 (0) {
  }
}
```

**目录与服务对应关系**

| 目录 | 服务 |
| --- | --- |
| audio | 音频文件识别 |
| audio_message | 音频消息识别 |
| audio_stream | 音频流识别 |
| image | 图片识别 |
| long_text | 长文本识别 |
| text | 文本识别 |
| video | 视频识别 |
| video_stream| 视频流识别 |