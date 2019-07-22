package com.example.jpademo;

import org.junit.Test;

/**
 * Classname SimpleTest
 * Description
 * Date 2019-07-02 17:50
 * Created by Wang jun gang
 */
public class SimpleTest {

    @Test
    public void splitTest() {
        String str = "/contract/EQIP01/201907/GLP-EQIP01-B2-1002-066-1-%E6%8B%85%E4%BF%9D%E5%87%BD-%E5%85%AC%E5%8F%B8.pdf";
        final String[] split = str.split("/");
        System.out.println(split[split.length - 1]);
        System.out.println(split[split.length - 1].split("\\.")[0]);
        System.out.println(str.substring(str.indexOf(".")));
        System.out.println("hello world" + null);
    }
}
