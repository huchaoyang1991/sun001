package com.sun.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
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
    public HttpRequestBase httpRequest(String url,String method) throws Exception {
        if (!StringUtils.hasLength(method))
            System.out.println("请输入正确的方法名：get/GET,post/POST,put/PUT,delete/DELETE");
        else if (method.equals("get") || method.equals("GET")) {
            HttpGet httpGet = new HttpGet(url);
            return (HttpRequestBase) httpGet;
        } else if (method.equals("post") || method.equals("POST")) {
            HttpPost httpPost = new HttpPost(url);
            return (HttpRequestBase) httpPost;
        } else if (method.equals("put") || method.equals("PUT")) {
            HttpPut httpPut = new HttpPut(url);
            return (HttpRequestBase) httpPut;
        } else if (method.equals("delete") || method.equals("DELETE")) {
            HttpDelete httpDelete = new HttpDelete(url);
            return (HttpRequestBase) httpDelete;
        }else
            System.out.println("请输入正确的方法名：get/GET,post/POST,put/PUT,delete/DELETE");
        return null;
    }
    //get或post参数传递
    public UrlEncodedFormEntity addParam(Map<String,String> data) throws Exception{
        List<NameValuePair> formParam=new ArrayList<NameValuePair>();
        //以key-value的方式传入formdata
        if(data.size()>0){
            for (String key:data.keySet()) {
                formParam.add(new BasicNameValuePair(key, data.get(key)));
            }//把传入的参数转码为utf-8
            return new UrlEncodedFormEntity(formParam,"utf-8");
        }else{
            System.out.println("输入formData格式有误");
            return null;
        }



    }
    //将服务器返回的body信息转换为String
    public String responseBody(HttpEntity entity) throws Exception{
        return EntityUtils.toString(entity);
    }

}
