package com.shumei;
import net.sf.json.JSONObject;

import java.util.HashMap;

public class Text {
    private String accessKey;
    private String type;
    private int connTimeOut;
    private int readTimeOut;
    public Text(String accessKey) {
        this.accessKey = accessKey;
        this.type = "ZHIBO";
        this.connTimeOut = 1000;
        this.readTimeOut = 1000;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setConnTimeOut(int connTimeOut) {
        this.connTimeOut = connTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public String invoke(HashMap<String, Object> data) throws Exception{
        HashMap<String, Object> userData = new HashMap<String, Object>();
        userData.put("accessKey", this.accessKey);
        userData.put("type", this.type);
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://api.fengkongcloud.com/v2/saas/anti_fraud/text", json, this.connTimeOut, this.readTimeOut);
        if (result == null) {
             throw new Exception("result is null");
        }
        return result.toString();
    }

    /*
    public static void main(String[] args) throws Exception{
        Text t = new Text("Qp8XPf4Y6BZPYDjGBmF2");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId","tokei");
        data.put("text", "iphone 7");
        System.out.println(t.invoke(data));
    }
    */
}
