package main

import (
	"bytes"
	"encoding/base64"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	url := "http://api-audio-bj.fengkongcloud.com/v2/saas/anti_fraud/audio"
	accessKey := "{ACCESS_KEY}"
	btId := "{BT_ID}"
	filename := "../files/demo.pcm"

	contentBytes, _ := ioutil.ReadFile(filename)
	content := base64.StdEncoding.EncodeToString(contentBytes)
	payload := map[string]interface{}{
		"accessKey": accessKey,
		"type":      "DEFAULT",
		"appId":     "default",
		"btId":      btId,
		"callback":  "https://jsonplaceholder.typicode.com/posts/",
		"data": map[string]interface{}{
			// url 和 content 至少提供一个
			// "url":  "https://jsonplaceholder.typicode.com/audio",
			"content": content,
			"formatInfo": map[string]interface{}{
				"format": "pcm",
				"rate":   8000,
				"track":  1,
			},
		},
	}
	b, _ := json.Marshal(payload)
	resp, _ := http.Post(url, "application/json", bytes.NewBuffer(b))

	var data map[string]interface{}
	if resp != nil {
		respBytes, _ := ioutil.ReadAll(resp.Body)
		_ = json.Unmarshal(respBytes, &data)
		// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
		fmt.Println(data)
	}
}
