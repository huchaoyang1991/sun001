package com.sun.api;

import com.sun.base.BaseTestCase;
import com.sun.service.TestService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/1.
 */
public class TestDemoService extends BaseTestCase{
    @Resource
    private TestService testService;
    CloseableHttpClient httpClient= HttpClients.createDefault();
    @BeforeClass
    public void beforeClass(){

    }
    @Test(testName = "测试基本get和post方法")
    public void main() throws Exception{
        testService.login();
    }
    @AfterClass
    public void afterClass() throws Exception{
        httpClient.close();
    }
}
