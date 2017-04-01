package com.sun.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * 此类用于base类，提供测试类方便的工具使用
 */
@ContextConfiguration("classpath*:applicationContext.xml")
public class BaseTestCase extends AbstractTestNGSpringContextTests{
}
