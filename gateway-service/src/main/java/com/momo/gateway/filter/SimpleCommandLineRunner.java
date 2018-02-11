package com.momo.gateway.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * @author majunjie
 * @date 2018/2/9 17:42
 */
public class SimpleCommandLineRunner extends ZuulFilter {

    String type;
    boolean shouldFilter;
    int order;
    RunInterface runInterface;

    public SimpleCommandLineRunner(String type, boolean shouldFilter, int order, RunInterface runInterface) {
        this.type = type;
        this.shouldFilter = shouldFilter;
        this.order = order;
        this.runInterface = runInterface;
    }

    @Override
    public String filterType() {
        return type;
    }

    @Override
    public int filterOrder() {
        return order;
    }

    @Override
    public boolean shouldFilter() {
        return shouldFilter;
    }

    @Override
    public Object run() {
        return runInterface.execute();
    }
}
