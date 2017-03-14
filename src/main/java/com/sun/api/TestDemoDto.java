package com.sun.api;

import com.alibaba.fastjson.JSON;
import com.sun.dto.CommonResponse;
import com.sun.dto.CommonResponseData;
import com.sun.util.HttpService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/14.
 */
public class TestDemoDto {
    CloseableHttpClient httpClient= HttpClients.createDefault();
    @Test(testName = "json对象解析")
    public void main() throws Exception{

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
        String body=httpService.responseBody(response.getEntity());
        // System.out.println(body);
        //把返回的JSON信息解析为java对象
        String status= JSON.parseObject(body, CommonResponse.class).getData();
        //把返回的JSON信息中的data数组解析为java对象
        String str= JSON.parseObject(status, CommonResponseData.class).getToken();
        System.out.println(str);
    }

}
