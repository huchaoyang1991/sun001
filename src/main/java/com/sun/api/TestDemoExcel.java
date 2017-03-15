package com.sun.api;

/**
 * Created by Administrator on 2017/3/14.
 */

import com.sun.util.ExcelData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

public class TestDemoExcel {

    @Test(testName = "测试数据驱动加载",dataProvider = "db2")
    public void ts(Map<String, String> data) throws Exception{
        System.out.println(data.get("part1"));
        System.out.println(data.keySet());
        System.out.println("=====over=====");
        System.out.println("");
    }

    @DataProvider(name = "db2")//db1的名字必须和Excel的文件名称一致
    public Iterator<Object[]> data() throws Exception{
        return new ExcelData("db2");
    }

}
