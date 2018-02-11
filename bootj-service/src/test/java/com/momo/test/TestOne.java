package com.momo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author majunjie
 * @date 2018/2/8 11:06
 */
@RunWith(Parameterized.class)
public class TestOne {

    private String name;

    public TestOne(String name) {
        this.name = name;
    }

    /**
     *
     * @author majunjie
     * @date 2018/2/8 11:06
     */
    @Test
    public void one() {
        System.out.println("TestOne.one()..." + name);
    }

    @Parameterized.Parameters
    public static Collection collection(){
        return Arrays.asList(new Object[]{"第一次测试","第二次测试","第三次测试"});
    }

}
