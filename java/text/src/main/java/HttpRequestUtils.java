package com.shumei;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;

public class HttpRequestUtils {
    /**
     * httpPost
     * @param url  路径
     * @param jsonParam 参数
     * @return
     */
    public static String httpPost(String url, String jsonParam, int conntimeout, int readtimeout) throws Exception{
        return httpPost(url, jsonParam, conntimeout, readtimeout, false);
    }

    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static String httpPost(String url,String jsonParam, int conntimeout, int readtimeout, boolean noNeedResponse) throws Exception{
        BasicHttpParams httpParams = new BasicHttpParams();  
        HttpConnectionParams.setConnectionTimeout(httpParams, conntimeout);  
        HttpConnectionParams.setSoTimeout(httpParams, readtimeout);
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);
        HttpPost method = new HttpPost(url);
        if (null != jsonParam) {
            //解决中文乱码问题
            StringEntity entity = new StringEntity(jsonParam, "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            method.setEntity(entity);
        }
        HttpResponse result = httpClient.execute(method);
        url = URLDecoder.decode(url, "UTF-8");
        /**请求发送成功，并得到响应**/
        String str = "";
        if (result.getStatusLine().getStatusCode() == 200) {
            /**读取服务器返回过来的json字符串数据**/
            str = EntityUtils.toString(result.getEntity());
            if (noNeedResponse) {
                return null;
            }
            /**把json字符串转换成json对象**/
        }else{
             throw new Exception("request failed: status code " + result.getStatusLine().getStatusCode());
        }
        return str;
    }
}
