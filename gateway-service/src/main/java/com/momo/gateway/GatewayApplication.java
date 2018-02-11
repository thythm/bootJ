package com.momo.gateway;

import com.momo.gateway.filter.SimpleCommandLineRunner;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.filters.FilterRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author majunjie
 * @date 2018/1/30 15:29
 */
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Component
    public static class AddFilter implements CommandLineRunner{

        @Override
        public void run(String... strings) throws Exception {
            FilterRegistry registry = FilterRegistry.instance();

            registry.put("test", new SimpleCommandLineRunner("", false, 12, () ->{
                RequestContext context = RequestContext.getCurrentContext();
                HttpServletRequest request = context.getRequest();
                System.out.println("name = " + request.getParameter("name"));
                context.setSendZuulResponse(true);// 对该请求进行路由
                context.setResponseStatusCode(200);
                context.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
                return null;
            }));
        }

    }

}
