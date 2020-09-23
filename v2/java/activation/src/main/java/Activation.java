import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/06/28.
 */

public class Activation {
    private static final String ACCESSKEY="xxxxxxxx"; // 商户的 accessKey
    private static final String APP_ID="default"; // 商户的 appId
    private static final String REQUEST_URL = "http://api.fengkongcloud.com/v2/event";

    public static void main(String[] args) {
        HashMap<String, Object> userData = new HashMap<String, Object>();
        //please set your own accessKey
        userData.put("accessKey", ACCESSKEY);
        userData.put("appId", APP_ID);
        userData.put("eventId", "activation");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("tokenId", "tokenId_test");
        data.put("ip", "127.0.0.1"); // 事件发生时的客户端ip地址
        data.put("deviceId", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); // 数美设备指纹标识
        data.put("timestamp", System.currentTimeMillis()); // 事件发生时的时间戳，单位为毫秒（ms）
        data.put("advertisingId", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"); // 广告计费的设备ID
        data.put("appVersion", "1.0.0"); // App版本号
        data.put("clickId", "qwer123456"); // 导致这次激活的点击ID
        data.put("clickIp", "10.168.18.78"); // 导致这次激活的点击发生的IP
        data.put("clickTimestamp", System.currentTimeMillis()); // 导致这次激活的点击事件时间戳，unix时间戳，单位为毫秒(ms)
        data.put("apputm", "channel"); // 本次激活来自的渠道标识
        data.put("campaign", "ad"); // 
        data.put("installTimestamp", System.currentTimeMillis()); // 本次激活的安装时间戳，unix时间戳，单位为毫秒（ms）
        data.put("isRetargeting", 0); // 本次激活是否来自retargeting广告

        userData.put("data", data);

        JSONObject json = JSONObject.fromObject(userData);
        JSONObject result = HttpRequestUtils.httpPost(REQUEST_URL, json);
        System.out.println(result.toString());

        json = JSONObject.fromObject(result);

        /**
         * 接口会返回code， code=1100 时说明请求成功，根据不同的 riskLevel 风险级别进行业务处理
         * 当 code!=1100 时，如果是 1902 错误，需要检查参数配置
         * 其余情况需要根据错误码进行重试或者其它异常处理
         */
        if (json.getInt("code")== 1100) {
            String riskLevel = json.getString("riskLevel");
            if (riskLevel == "PASS") {
                // 放行
            } else if (riskLevel == "REVIEW") {
                // 人工审核，如果没有审核，就放行
            } else if (riskLevel == "REJECT") {
                // 拒绝
            } else {
                // 异常
            }
        } else {
            // 接口请求失败，需要参照返回码进行不同的处理
        }

    }
}
