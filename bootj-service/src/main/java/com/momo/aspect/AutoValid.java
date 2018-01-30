package com.momo.aspect;

import com.momo.annotation.Valid;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 * @author majunjie
 * @description TODO 方法参数的自动校验，待实现
 * @date 2017/10/25 13:32
 */
@Aspect
//@Component
public class AutoValid {

    @Pointcut("execution(* com.momo.service.RedisService.*(..))")
    private void anyMethod(){}

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @Before("anyMethod()&&@annotation(valid)")
//    @Before("@annotation(valid)")
    public void pre(JoinPoint point, Valid valid){

        System.out.println(valid.value());

    }

}
