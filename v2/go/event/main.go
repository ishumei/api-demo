package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"time"
)

func main() {
	url := "http://api-skynet-bj.fengkongcloud.com/v3/event"
	accessKey := "{ACCESS_KEY}"
	eventId := "register"

	payload := map[string]interface{}{
		"accessKey": accessKey,
		"appId":     "default",
		"eventId":   eventId,
		"data": map[string]interface{}{
			"tokenId":   "{UID}",
			"ip":        "127.0.0.1",
			"timestamp": time.Now().UnixNano() / int64(time.Millisecond),
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
