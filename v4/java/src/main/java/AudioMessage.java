import net.sf.json.JSONObject;

import java.util.HashMap;

public class AudioMessage {
    private static final String URL = "http://api-audiomessage-bj.fengkongcloud.com/audiomessage/v4";
    private static final String ACCESS_KEY = "{ACCESS_KEY}";

    public static void main(String[] args) {
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("accessKey", ACCESS_KEY);
        payload.put("appId", "default");
        payload.put("eventId", "audio");
        payload.put("type", "ALL");
        payload.put("content", Utils.readFileToBase64("../files/demo.pcm"));
        payload.put("contentType", "RAW");
        payload.put("btId", "{BT_ID}");
        payload.put("callback", "https://jsonplaceholder.typicode.com/posts/");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("format", "pcm");
        data.put("rate", 8000);
        data.put("track", 1);

        payload.put("data", data);

        JSONObject json = JSONObject.fromObject(payload);
        JSONObject result = Utils.httpPost(URL, json);

        json = JSONObject.fromObject(result);
        System.out.println(json.toString());
    }
}