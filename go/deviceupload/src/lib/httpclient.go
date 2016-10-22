package httpclient

import (
	"io/ioutil"
	"net"
	"net/http"
	"net/url"
	"strings"
	"time"
)

type HttpClient struct {
	Client http.Client
}

func NewHttpClient(connTimeout time.Duration, readTimeout time.Duration) HttpClient {
	client := http.Client{
		Transport: &http.Transport{
			Dial: func(netw, addr string) (net.Conn, error) {
				c, err := net.DialTimeout(netw, addr, connTimeout)
				if err != nil {
					return nil, err
				}
				c.SetDeadline(time.Now().Add(readTimeout))
				return c, nil
			},
		},
	}
	return HttpClient{Client: client}
}

func (this *HttpClient) SendGetRequest(httpUrl string, postParams map[string]string) (string, error) {
	u, _ := url.Parse(httpUrl)
	q := u.Query()
	for key, value := range postParams {
		q.Set(key, value)
	}
	u.RawQuery = q.Encode()

	resp, reqErr := this.Client.Get(u.String())

	if reqErr != nil {
		return "", reqErr
	}

	defer resp.Body.Close()

	data, respErr := ioutil.ReadAll(resp.Body)

	if respErr != nil {
		return "", respErr
	}
	return string(data), nil
}

func (this *HttpClient) SendPostRequest(httpUrl string, headers map[string]string, body string) (string, error) {

	req, _ := http.NewRequest("POST", httpUrl, strings.NewReader(body))

	for key, value := range headers {
		req.Header.Set(key, value)
	}

	resp, reqErr := this.Client.Do(req)

	if reqErr != nil {
		return "", reqErr
	}

	defer resp.Body.Close()

	data, respErr := ioutil.ReadAll(resp.Body)

	if respErr != nil {
		return "", respErr
	}

	return string(data), nil
}
