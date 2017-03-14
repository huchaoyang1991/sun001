package com.sun.util;

import bsh.StringUtil;
import com.sun.java.util.jar.pack.Instruction;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/14.
 */
public class HttpService {
    public void httpRequest(String url,String method) throws Exception{
        if(!StringUtils.hasLength(method))
            System.out.println("请输入正确的方法名：get/GET,post/POST,put/PUT,delete/DELETE");
        else if (method.equals("get")||method.equals("GET")){
            HttpGet httpGet=new HttpGet(url);
            return;
        }
        else if(method.equals("post")||method.equals("POST")){
            return;
        }
        else if(method.equals("put")||method.equals("PUT")){
            return;
        }else if(method.equals("delete")||method.equals("DELETE")){
            return;
        }

    }
    //get或post参数传递
    public UrlEncodedFormEntity addParam(Map<String,String> data) throws Exception{
        List<NameValuePair> formParam=new ArrayList<NameValuePair>();
        //以key-value的方式传入formdata
        if(data.size()>0){
            for (String key:data.keySet()) {
            formParam.add(new BasicNameValuePair(key, data.get(key)));
            }
        }
        //把传入的参数转码为utf-8
        return new UrlEncodedFormEntity(formParam,"utf-8");
    }
    //将服务器返回的body信息转换为String
    public String responseBody(HttpEntity entity) throws Exception{
        return EntityUtils.toString(entity);
    }

}
