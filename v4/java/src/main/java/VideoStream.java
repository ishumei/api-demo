import net.sf.json.JSONObject;

import java.util.HashMap;

public class VideoStream {
    private static final String URL = "http://api-videostream-sh.fengkongcloud.com/videostream/v4";
    private static final String ACCESS_KEY = "{ACCESS_KEY}";

    public static void main(String[] args) {
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("accessKey", ACCESS_KEY);
        payload.put("appId", "default");
        payload.put("eventId", "video");
        payload.put("imgType", "POLITY_QRCODE_ADVERT");
        payload.put("audioType", "POLITY_EROTIC");
        payload.put("callback", "https://jsonplaceholder.typicode.com/posts/");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("url", "https://jsonplaceholder.typicode.com/posts/");
        data.put("streamType", "NORMAL");
        data.put("btId", "{BT_ID}");

        payload.put("data", data);

        JSONObject json = JSONObject.fromObject(payload);
        JSONObject result = Utils.httpPost(URL, json);

        json = JSONObject.fromObject(result);
        System.out.println(json.toString());
    }
}