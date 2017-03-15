package com.sun.api;

import com.sun.util.HttpService;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/14.
 */
public class TestDemo {
    CloseableHttpClient httpClient= HttpClients.createDefault();
    @BeforeClass
    public void beforeClass(){

    }
    @Test(testName = "测试基本get和post方法")
    public void main() throws Exception{
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpService httpService=null;//用于转换编码
        HttpPost httpPost=null;//接收post请求信息
        CloseableHttpResponse response=null;//接受服务器返回信息
        //添加post请求的url
        httpPost=new HttpPost("https://member.pinganfang.com/v2/api/web/user/login");
        //HttpGet httpGet=new HttpGet("url");
        //添加post请求的formdata
        Map<String,String> param= new HashMap<String,String>();
        param.put("mobile", "18601669325");
        param.put("password", "647871b841381eec91b609e217a621fa");
        //将map转换为formData
        HttpEntity httpEntity=httpService.addParam(param);
        //将参数传入http请求对象
        httpPost.setEntity(httpEntity);
        //接收服务器的返回信息

        response=httpClient.execute(httpPost);
        //response=httpClient.execute(httpGet);
        //打印服务器返回body信息，并将实体类转换为String
        System.out.println(httpService.responseBody(response.getEntity()));
        //打印服务器返回状态
        System.out.println(response.getStatusLine());
        //打印服务器的headers信息
        for (Header head:response.getAllHeaders()) {
            System.out.println(head);
        }
    }
    @AfterClass
    public void afterClass() throws Exception{
        httpClient.close();
    }
}
