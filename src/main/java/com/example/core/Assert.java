package com.example.core;

/**
 * @author majunjie
 * @description 使代码看起来更加优雅，便于维护
 * @date 2017/10/25 11:05
 */
public class Assert {

    public static void isTure(boolean result, String title){

        if (!result) {
            throw new MMException(title);
        }

    }

}
