package com.momo.anno;

import com.momo.annotation.NotNull;
import com.momo.proxy.Proxy;

/**
 * @author majunjie
 * @description
 * @date 2017/12/18 11:25
 */
public class TestBean {


    public static void main(String[] args) {

        TestBean test = new Proxy<TestBean>().getProxy(TestBean.class);

//        test.test();

        test.testString(null);

    }

    public void testString(@NotNull String var1){
        System.out.println("success into testString()");
    }

    public void test(){
        System.out.println("success into test()");
    }

}
