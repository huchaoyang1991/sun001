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

    @Test(dataProvider = "db1")
    public void ts(Map<String, String> data) throws Exception{
        System.out.println(data.get("part1"));
        System.out.println("=====over=====");
        System.out.println("");
    }

    @DataProvider(name = "db1")
    public Iterator<Object[]> data() throws Exception{
        return (Iterator<Object[]>)new ExcelData("ExcelTest","testB");
    }

}
