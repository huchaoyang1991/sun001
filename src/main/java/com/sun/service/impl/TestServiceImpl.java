package com.sun.service.impl;

import com.sun.common.UserInfo;
import com.sun.service.TestService;
import com.sun.util.HttpService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class TestServiceImpl implements TestService {
    CloseableHttpClient httpClient= HttpClients.createDefault();
    private  HttpService httpService =new HttpService();//用于转换编码
    private  HttpPost httpPost;//接收post请求信息
    private CloseableHttpResponse response;//接受服务器返回信息

    public void login(String username, String password) throws Exception{
        username= UserInfo.USERNAME;
        password=UserInfo.PASSWORD;

        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpService httpService=new HttpService();//用于转换编码
        HttpPost httpPost=null;//接收post请求信息
        CloseableHttpResponse response=null;//接受服务器返回信息
        //添加post请求的url
        httpPost=new HttpPost("https://member.pinganfang.com/v2/api/web/user/login");
        //HttpGet httpGet=new HttpGet("url");
        //添加post请求的formdata
        Map<String,String> param= new HashMap<String,String>();
        param.put("mobile", username);
        param.put("password", password);
        //将map转换为formData
        HttpEntity httpEntity = null;
        try {
            httpEntity = httpService.addParam(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将参数传入http请求对象
        httpPost.setEntity(httpEntity);
        //接收服务器的返回信息

        response=httpClient.execute(httpPost);
        System.out.println(response.getStatusLine());
        return ;
    }
    public void login() throws Exception{
        this.login(UserInfo.USERNAME,UserInfo.PASSWORD);
    }
}
