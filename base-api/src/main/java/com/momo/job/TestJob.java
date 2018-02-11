package com.momo.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * @author majunjie
 * @date 2018/2/11 10:06
 */
@JobHandler(value = "testJob")
@Component
public class TestJob extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println("hello world!!!");
        return SUCCESS;
    }

}
