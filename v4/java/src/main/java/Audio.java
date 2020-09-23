import net.sf.json.JSONObject;

import java.util.HashMap;

public class Audio {
    private static final String URL = "http://api-audio-bj.fengkongcloud.com/audio/v4";
    private static final String ACCESS_KEY = "{ACCESS_KEY}";

    public static void main(String[] args) {
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("accessKey", ACCESS_KEY);
        payload.put("appId", "default");
        payload.put("eventId", "audio");
        payload.put("type", "DEFAULT");
        payload.put("contentType", "RAW");
        payload.put("content", Utils.readFileToBase64("../files/demo.pcm"));
        payload.put("btId", "{BT_ID}");
        payload.put("callback", "https://jsonplaceholder.typicode.com/posts/");

        HashMap<String, Object> data = new HashMap<String, Object>();
        HashMap<String, Object> dataInfo = new HashMap<String, Object>();
        dataInfo.put("format", "pcm");
        dataInfo.put("rate", 8000);
        dataInfo.put("track", 1);

        data.put("formatInfo", dataInfo);
        payload.put("data", data);

        JSONObject json = JSONObject.fromObject(payload);
        JSONObject result = Utils.httpPost(URL, json);

        json = JSONObject.fromObject(result);
        System.out.println(json.toString());
    }
}