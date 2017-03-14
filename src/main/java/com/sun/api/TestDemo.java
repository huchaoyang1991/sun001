package com.sun.api;

import com.sun.util.HttpService;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/14.
 */
public class TestDemo {
    @Test
    public void main() throws Exception{
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //添加post请求的url
        HttpPost httpPost=new HttpPost("https://member.pinganfang.com/v2/api/web/user/login");
        //HttpGet httpGet=new HttpGet("url");
        //添加post请求的formdata
        Map<String,String> param= new HashMap<String,String>();
        param.put("mobile", "18601669325");
        param.put("password", "647871b841381eec91b609e217a621fa");
        //声明一个HttpService工具用来转换编码
        HttpService httpService=new HttpService();
        HttpEntity httpEntity=httpService.addParam(param);
        httpPost.setEntity(httpEntity);
        //接收服务器的返回信息
        CloseableHttpResponse response=null;
        response=httpClient.execute(httpPost);
        //response=httpClient.execute(httpGet);
        //打印服务器返回body信息
        //打印服务器返回body信息
        System.out.println(httpService.responseBody(response.getEntity()));
        //打印服务器返回状态
        System.out.println(response.getStatusLine());
        //打印服务器的headers信息
        for (Header head:response.getAllHeaders()) {
            System.out.println(head);
        }




    }
}
