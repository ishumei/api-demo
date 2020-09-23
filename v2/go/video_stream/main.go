package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	url := "http://api-videostream-bj.fengkongcloud.com/v3/saas/anti_fraud/videostream"
	accessKey := "{ACCESS_KEY}"
	uid := "{UID}"
	videoUrl := "https://jsonplaceholder.typicode.com/posts/"

	payload := map[string]interface{}{
		"accessKey":   accessKey,
		"appId":       "default",
		"imgType":     "POLITICS_PORN_AD",
		"audioType":   "NONE",
		"imgCallback": "https://jsonplaceholder.typicode.com/posts/",
		"data": map[string]interface{}{
			"streamType": "NORMAL",
			"tokenId":    uid,
			"url":        videoUrl,
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
