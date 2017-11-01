/**
 * Created by Administrator on 2016/10/20.
 */

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;

public class HttpRequestUtils {
    /**
     * httpPost
     * @param url 请求的url
     * @param jsonParam 请求数据
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam){
        return httpPost(url, jsonParam, false);
    }

    /**
     * httpPost
     * @param url           请求url
     * @param jsonParam
     * @param noNeedResponse  是否获取接口response
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
        CloseableHttpClient httpClient = HttpClients.createDefault();

        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                StringEntity entity = new StringEntity(jsonParam.toString(), "UTF-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    str = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    jsonResult = JSONObject.fromObject(str);
                } catch (Exception e) {
                    System.out.println("posturl:" + url + ", err=" + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("posturl:" + url + ", err=" + e.getMessage());
        }
        return jsonResult;
    }


    /**
     * httpGet
     * @param url
     * @return
     */
    public static JSONObject httpGet(String url){
        JSONObject jsonResult = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                String strResult = EntityUtils.toString(response.getEntity());
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                System.out.println("geturl:" + url);
            }
        } catch (IOException e) {
            System.out.println("geturl" + url + ", err=" + e.getMessage());
        }
        return jsonResult;
    }
}