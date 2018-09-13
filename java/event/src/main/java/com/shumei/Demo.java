package com.shumei;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;

public class Demo {
    public static void main(String[] args) throws Exception {
        // 替换url为被调用的url。
        String baseUrl = "http://api.fengkongcloud.com/v2/event";

        HashMap<String, Object> body = new HashMap<String, Object>();

        body.put("accessKey", "<access-key>");  // 替换<access-key>为自己的
        body.put("appId", "default");
        body.put("eventId", "like");

        // 在data中填写入API手册要求的字段
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("contentId", "5b8c03acaa8d375d3ce602ff");
        data.put("contentType", "video");
        data.put("deviceId", "201809030249165e92ca9c0eac886ecfc8362822827c5201d258b02cb6a0fb");
        data.put("ip", "222.93.217.176");
        data.put("tokenId", "5b8502508249087d16d097cd");

        body.put("data", data);

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(baseUrl);
        StringEntity entity = new StringEntity(JSONObject.fromObject(body).toString(), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        String rawResponse = EntityUtils.toString(response.getEntity());

        System.out.println("Raw Response:");
        System.out.println(rawResponse);

        System.out.println("");
        JSONObject jsonResponse = JSONObject.fromObject(rawResponse);
        int code = jsonResponse.getInt("code");
        String message = jsonResponse.getString("message");
        System.out.println("code = " + code + ", message = " + message);

        JSONObject token = jsonResponse.getJSONObject("detail").getJSONObject("token");
        String riskReason = token.getString("riskReason");
        System.out.println("riskReason = " + riskReason);
    }
}
