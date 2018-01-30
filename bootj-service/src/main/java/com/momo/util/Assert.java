package com.momo.util;

import com.momo.execption.MMException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author majunjie
 * @description 使代码看起来更加优雅，便于维护
 * @date 2017/10/25 11:05
 */
public class Assert {

    public static void isTrue(boolean result, String title){

        if (!result) {
            throw new MMException(title);
        }

    }

    public static void notBlank(String str, String title){

        if (StringUtils.isBlank(str)) {
            throw new MMException(title);
        }

    }

    public static void notNull(Object obj, String title){

        if (obj==null) {
            throw new MMException(title);
        }

    }

}
