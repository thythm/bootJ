package com.momo.proxy;

import com.momo.annotation.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author majunjie
 * @description
 * @date 2017/12/18 11:52
 */
public class Proxy<T> implements MethodInterceptor{

    private final static Logger logger = LoggerFactory.getLogger(Proxy.class);

    private Class<T> clz;

    private T obj;

    public T getProxy(Class<T> clz){
        this.clz = clz;
        return (T) Enhancer.create(clz, this);
    }

    public T getProxy(T obj){
        this.obj = obj;
        return (T) Enhancer.create(obj.getClass(), this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (obj!=null) {
            o = obj;
        }
        //before、前置处理

        System.out.println("before...........");
        Parameter[] parameters = method.getParameters();

        if (parameters!=null) {
            for (Parameter parameter : parameters) {
                //非空校验
                NotNull annotation = parameter.getDeclaredAnnotation(NotNull.class);
                if (annotation!=null) {
                    for (Object object : objects) {
                        if (object==null) {
                            String[] arr = NotNull.class.getName().split("\\.");
                            logger.warn("condition：" + arr[arr.length-1] + "，param：" + object);
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        }

        //step1、类注解拦截处理

        //step2、方法注解拦截处理

        //step3、方法参数注解拦截处理

        //step4、执行目标方法
        Object result = methodProxy.invokeSuper(o, objects);

        //after、后置处理

        System.out.println("after...........");

        //返回执行结果
        return result;
    }
}
