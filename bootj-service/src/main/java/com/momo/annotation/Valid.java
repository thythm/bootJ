package com.momo.annotation;

import java.lang.annotation.*;

/**
 * @author majunjie
 * @description
 * @date 2017/10/25 13:46
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
@Documented
public @interface Valid {

    String value() default "";

}
