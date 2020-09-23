import net.sf.json.JSONObject;

import java.util.HashMap;

public class Event {
    private static final String URL = "http://api-skynet-bj.fengkongcloud.com/v3/event";
    private static final String ACCESS_KEY = "{ACCESS_KEY}";
    private static final String EVENT_ID = "register";

    public static void main(String[] args) {
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("accessKey", ACCESS_KEY);
        payload.put("appId", "default");
        payload.put("eventId", EVENT_ID);

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "{UID}");
        data.put("ip", "127.0.0.1");
        data.put("timestamp", System.currentTimeMillis());

        payload.put("data", data);

        JSONObject json = JSONObject.fromObject(payload);
        JSONObject result = Utils.httpPost(URL, json);

        json = JSONObject.fromObject(result);
		// 通过 code 和 riskLevel 判断返回，具体请参考接口文档
        System.out.println(json.toString());
    }
}