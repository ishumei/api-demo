package com.shumei;
import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/20.
 */

public class Text {
    private String accessKey;
    private String type;
    private int conntimeout;
    private int readtimeout;
    public Text(String accessKey, String type, int conntimeout, int readtimeout) {
        this.accessKey = accessKey;
        this.type = type;
        this.conntimeout = conntimeout;
        this.readtimeout = readtimeout;
    }
    public String invoke(HashMap<String, Object> data) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", this.accessKey);
        userData.put("type", this.type);
        userData.put("data", data);
        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost("http://api.fengkongcloud.com/v2/saas/anti_fraud/text", json, this.conntimeout, this.readtimeout);
        //System.out.println(result.toString());
        return result.toString();
    }
}
