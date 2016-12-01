package org.tj.util.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 001 on 16/8/31.
 */
public class HttpClientUtil {


    private static PoolingHttpClientConnectionManager clientConnectionManager = null;
    static HttpHost localhost = new HttpHost("183.158.205.88",9000,"HTTP");


    static {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainsf)
                .register("https", sslsf)
                .build();
        clientConnectionManager = new PoolingHttpClientConnectionManager(registry);
        clientConnectionManager.setMaxTotal(200);
        // 将每个路由基础的连接增加到20
        clientConnectionManager.setDefaultMaxPerRoute(20);
        // 将目标主机的最大连接数增加到50
        clientConnectionManager.setMaxPerRoute(new HttpRoute(localhost), 50);
    }

    private  static CloseableHttpClient getHttpClient(){
        return HttpClients.custom()
                .setConnectionManager(clientConnectionManager)
                .build();
    }

//    public static void main(String[] args) {
//        UUID.randomUUID();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("phone","18611516867");
//        jsonObject.put("landing_number","01065447657");
//        System.out.println(sendPost("http://gz.fahai.com/hotline_test/landing/calls",null,jsonObject).getBody());
//    }

//
    public static Result sendGet(String url) {
        HttpGet get = new HttpGet(url);
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;
        try {
            response = httpClient.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Result result = getResult(httpClient,response);
        return result;
    }

    public static Result sendGet(String url,Map<String,String> params)  {
        return sendGet(url,null,params);
    }

    public static Result sendGet(String url,Map<String,String> headers,Map<String,String> params) {
        url = (null == params ? url : url + "?" + parseParam(params));

        HttpGet get = new HttpGet(url);
        if (headers != null){
            get.setHeaders(parseHeader(headers));
        }
        CloseableHttpClient httpClient = getHttpClient();
        HttpResponse response = null;
        try {
            response = httpClient.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Result result = getResult(httpClient,response);
        return result;
    }

    //json
    public static Result sendPost(String url, Map<String, String> headers, JSONObject paramJson) {
        return sendPost(url,headers,paramJson.toJSONString());
    }

    //json
    public static Result sendPost(String url, Map<String, String> headers, String jsonStr) {
        CloseableHttpClient httpClient = getHttpClient();
        HttpPost post = new HttpPost(url);

        StringEntity reqEntity = new StringEntity(jsonStr,"utf-8");//解决中文乱码问题
        reqEntity.setContentEncoding("UTF-8");
        reqEntity.setContentType("application/json");

        post.setEntity(reqEntity);
        if (headers != null){
            post.setHeaders(parseHeader(headers));
        }
        HttpResponse response = null;
        Result result = null;
        try {
            response = httpClient.execute(post);
            result = getResult(httpClient,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Result post(String url, Map<String, String> headers, Map<String, String> params, String encoding) throws IOException {


//        cookieStore = new BasicCookieStore();
        //       client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpClient httpClient = getHttpClient();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (String temp : params.keySet()) {
            list.add(new BasicNameValuePair(temp, params.get(temp)));
        }
        post.setEntity(new UrlEncodedFormEntity(list, encoding));

        post.setHeaders(parseHeader(headers));
        HttpResponse response = httpClient.execute(post);
        Result result = getResult(httpClient,response);
        return result;
    }

    public static Result postForm(Map<String,String> params,String url){
        Result result = null;
        try {
            CloseableHttpClient httpClient = getHttpClient();
            List<NameValuePair> pairs = new ArrayList<>();
            StringBuffer paramStr = new StringBuffer();
            for (String key:params.keySet()){
                pairs.add(new BasicNameValuePair(key,params.get(key)));
                key = URLEncoder.encode(key,"UTF-8");
                String value = URLEncoder.encode(params.get(key),"UTF-8");
//                String value = params.get(key);
                paramStr.append(key).append("=").append(value).append("&");
            }
            String paramString =paramStr.toString();
            paramString = paramString.substring(0,paramStr.length()-1);
            System.out.println(paramString);

            HttpPost post = new HttpPost(url);
            post.setEntity(new StringEntity(paramString));
//            StringEntity stringEntity = new StringEntity(paramString);
//            stringEntity.setContentType("application/x-www-form-urlencoded");
//            stringEntity.setContentEncoding("UTF-8");
//            post.setEntity(stringEntity);
            HttpResponse response = null;

            try {
                response = httpClient.execute(post);
                result = getResult(httpClient,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String parseParam(Map<String, String> params)  {
        if (null == params || params.isEmpty()) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String key : params.keySet()) {
            try {
                sb.append(URLEncoder.encode(key, "utf-8") + "=" + URLEncoder.encode(params.get(key), "utf-8") + "&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static Header[] parseHeader(Map<String, String> headers) {
        if (null == headers || headers.isEmpty()) {
            return new BasicHeader[2];
        }
        Header[] allHeader = new BasicHeader[headers.size()];
        int i = 0;
        for (String str : headers.keySet()) {
            allHeader[i] = new BasicHeader(str, headers.get(str));
            i++;
        }
        return allHeader;
    }


    public static Result getResult(CloseableHttpClient httpClient,HttpResponse response){
        Result result = new Result();
        result.setHttpClient(httpClient);
        result.setStatusCode(response.getStatusLine().getStatusCode());
        result.setHeaders(response.getAllHeaders());
        result.setHttpEntity(response.getEntity());
        try {
            result.setBody(EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.getStatusCode() != 200){
            System.out.println(result.getStatusCode()+" : "+result.getBody());
//            logger.error(result.getStatusCode()+" : "+result.getBody());
        }
        return result;
    }


}
