package main

import (
	"encoding/json"
	"fmt"
	"lib"
	"strconv"
)

type ShumeiDURequest struct {
	Organization string                 `json:"organization"`
	Data         map[string]interface{} `json:"data"`
}

func main() {
	hc := httpclient.NewHttpClient(1e9, 1e9)
	url := "http://fp.fengkongcloud.com/v1/profile"
	//set your own accessKey
	smtr := ShumeiDURequest{"xxxxxxxxxxxxxxxxxxxx", map[string]interface{}{"fingerprint": "866657020185815", "sessionId": "0987654321"}}
	bys, _ := json.Marshal(&smtr)
	header := map[string]string{"Content-Type": "application/json", "Content-Length": strconv.Itoa(len(string(bys)))}
	response, err := hc.SendPostRequest(url, header, string(bys))
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	fmt.Println(response)
}
