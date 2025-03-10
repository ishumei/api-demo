import net.sf.json.JSONObject;

import java.util.HashMap;

public class Image {
    private static final String URL = "http://api-img-bj.fengkongcloud.com/image/v4";
    private static final String ACCESS_KEY = "{ACCESS_KEY}";

    public static void main(String[] args) {
        HashMap<String, Object> payload = new HashMap<String, Object>();
        payload.put("accessKey", ACCESS_KEY);
        payload.put("appId", "default");
        payload.put("eventId", "default");
        payload.put("type", "POLITY_QRCODE_ADVERT");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("img", Utils.readFileToBase64("../files/demo.png"));
        data.put("tokenId", "{UID}");

        payload.put("data", data);

        JSONObject json = JSONObject.fromObject(payload);
        JSONObject result = Utils.httpPost(URL, json);

        json = JSONObject.fromObject(result);
        System.out.println(json.toString());
    }
}
