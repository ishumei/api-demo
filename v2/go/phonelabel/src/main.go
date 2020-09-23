/**
 * 运行本demo，运行 sh run.sh 即可
**/

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

type ShumeiFLResult struct {
	Code          int           `json:"code"`
	Message       string        `json:"message"`
	Labels        []interface{} `json:"labels"`
	RequestId     string        `json:"requestId"`
	VirtualNumber int           `json:"virtualNumber"`
}

func main() {
	hc := httpclient.NewHttpClient(1e9, 5e9)
	url := "https://finance-api.fengkongcloud.com/v2/finance/labels"
	//set your own accessKey
	smtr := ShumeiPLRequest{"xxxxxxx", map[string]interface{}{"phone": "18687082306"}}
	bys, _ := json.Marshal(&smtr)
	header := map[string]string{"Content-Type": "application/json", "Content-Length": strconv.Itoa(len(string(bys)))}

	response, err := hc.SendPostRequest(url, header, string(bys))
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}
	fmt.Println(response)

	resJson := ShumeiFLResult{}
	err = json.Unmarshal([]byte(response), &resJson)
	if err != nil {
		fmt.Println(fmt.Sprintf("Error: %v\n", err))
		return
	}

	/**
	 * 接口会返回code， code=1100 时说明请求成功
	 * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
	 * 其余情况需要根据错误码进行重试或者其它异常处理
	 */
	if resJson.Code == 1100 {
		// 正常业务处理
	} else {
		// 接口请求失败，需要参照返回码进行不同的处理
	}
}
