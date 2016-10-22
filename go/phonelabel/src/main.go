package main

import (
	"encoding/json"
	"fmt"
	"lib"
	"strconv"
)

type ShumeiPLRequest struct {
	AccessKey string                 `json:"accessKey"`
	Data      map[string]interface{} `json:"data"`
}

func main() {
	hc := httpclient.NewHttpClient(1e9, 1e9)
	url := "https://finance-api.fengkongcloud.com/v2/finance/labels"
	//set your own accessKey
	smtr := ShumeiPLRequest{"4Ky6AV4hE0pWLeG1bXNw", map[string]interface{}{"phone": "18687082306"}}
	bys, _ := json.Marshal(&smtr)
	header := map[string]string{"Content-Type": "application/json", "Content-Length": strconv.Itoa(len(string(bys)))}
	response, err := hc.SendPostRequest(url, header, string(bys))
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	fmt.Println(response)
}
