package com.example.aspect;

import com.example.annotation.Valid;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author majunjie
 * @description TODO 方法参数的自动校验，待实现
 * @date 2017/10/25 13:32
 */
@Aspect
//@Component
public class AutoValid {

    @Pointcut("execution(* com.example.service.RedisService.*(..))")
    private void anyMethod(){}

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

//    @Before("anyMethod()")
    @Before("@annotation(valid)")
    public void pre(JoinPoint point, Valid valid){

        System.out.println(valid.value());

        /*MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
//        System.out.println(method.getName());
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            Annotation[] annotations = parameter.getDeclaredAnnotations();
            if (annotations==null) {
                continue;
            }
            for (Annotation annotation : annotations) {
//                System.out.println(annotation);


            }
        }*/
    }

}
