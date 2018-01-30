package com.momo.annotation;

import java.lang.annotation.*;

/**
 * Created by PC on 2017/12/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface NotNull {

}
