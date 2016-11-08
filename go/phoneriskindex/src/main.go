package main

import (
	"encoding/json"
	"fmt"
	"lib"
	"strconv"
)

type SContact struct {
	Phone string `json:"phone"`
	Name  string `json:"name"`
}
type SRecord struct {
	Phone     string `json:"phone"`
	Type      int    `json:"type"`
	StartTime int    `json:"startTime"`
	Duration  int    `json:"duration"`
}
type SPRIReqData struct {
	Phone    string     `json:"phone"`
	Imei     string     `json:"imei"`
	Records  []SRecord  `json:"records"`
	Contacts []SContact `json:"contacts"`
}
type ShumeiPRIRequest struct {
	AccessKey string      `json:"accessKey"`
	Data      SPRIReqData `json:"data"`
}

func main() {
	hc := httpclient.NewHttpClient(1e9, 1e9)
	url := "http://finance-api.fengkongcloud.com/v2/finance/malagent"
	contacts := []SContact{SContact{"18687908768", "大志"}}
	records := []SRecord{SRecord{"18512365786", 0, 1477050308, 100}}
	rd := SPRIReqData{"18687082306", "866657020185815", records, contacts}
	//set your own accessKey
	smtr := ShumeiPRIRequest{"XXXXXXXXXXXXXXXXXXXX", rd}
	bys, _ := json.Marshal(&smtr)
	header := map[string]string{"Content-Type": "application/json", "Content-Length": strconv.Itoa(len(string(bys)))}
	response, err := hc.SendPostRequest(url, header, string(bys))
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	fmt.Println(response)
}
