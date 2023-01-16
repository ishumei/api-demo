
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Event {
    //    private static final String URL = "http://api-skynet-bj.fengkongcloud.com";
    private static final String URL = "http://url/v4/event";
    private static final String ACCESSKEY = "{accesskey}";


    public static class params {
        public String accessKey;
        public String appId;
        public String eventId;

        public HashMap<String, Object> data;

        public void setAccessKey(String accessKey_) {
            accessKey = accessKey_;
        }

        public void setAppId(String appId_) {
            appId = appId_;
        }

        public void setData(HashMap<String, Object> data_) {
            data = data_;
        }

        public void setEventId(String eventId_) {
            eventId = eventId_;
        }

        public String call() {
            JSONObject json = (JSONObject) JSONObject.toJSON(this);
            System.out.println(json);
            net.sf.json.JSONObject result = Utils.httpPost(URL, net.sf.json.JSONObject.fromObject(json));

            return result.toString();
        }

        @Override
        public String toString() {
            return "params{" +
                    "AccessKey='" + accessKey + '\'' +
                    ", AppId='" + appId + '\'' +
                    ", EventId='" + eventId + '\'' +
                    ", Data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {

        params params = new params();
        params.setAccessKey(ACCESSKEY);
        params.setEventId("leadsSubmit");
        params.setAppId("default");
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "123123");
        data.put("ip", "63.12.13.15");
        data.put("phone", "17598789345");
        data.put("timestamp", LocalDateTime.now());
        params.setData(data);

        System.out.println(params);
        String result = params.call();
        System.out.println(result);


    }
}

