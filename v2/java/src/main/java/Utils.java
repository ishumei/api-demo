import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.URLDecoder;

class Utils {
    public static JSONObject httpPost(String url, JSONObject jsonParam) {
        return httpPost(url, jsonParam, false);
    }

    public static JSONObject httpPost(String url, JSONObject jsonParam, boolean noNeedResponse) {
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

    public static String readFileToBase64(String filename) {
        try {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[(int) file.length()];
            fis.read(buf);
            fis.close();
            return new String(Base64.encodeBase64(buf), "ISO-8859-1");
        } catch (IOException e) {
            return "";
        }
    }
}