package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	url := "http://api-text-bj.fengkongcloud.com/longtext/v4"
	accessKey := "{ACCESS_KEY}"
	text := "{TEXT}"
	uid := "{UID}"

	payload := map[string]interface{}{
		"accessKey": accessKey,
		"appId":     "default",
		"eventId":   "default",
		"type":      "ALL",
		"data": map[string]string{
			"text":    text,
			"tokenId": uid,
		},
	}
	b, _ := json.Marshal(payload)
	resp, _ := http.Post(url, "application/json", bytes.NewBuffer(b))

	var data map[string]interface{}
	if resp != nil {
		respBytes, _ := ioutil.ReadAll(resp.Body)
		_ = json.Unmarshal(respBytes, &data)
		fmt.Println(data)
	}
}
