package org.tj.spider.http;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;

/**
 * Created by 001 on 16/12/7.
 */
public class HttpClientFoctory {



    public static HttpClient getProxyHost(String host,int port){
        HttpHost proxy = new HttpHost(host, port);
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        return HttpClients.custom().setRoutePlanner(routePlanner).build();
    }

}
