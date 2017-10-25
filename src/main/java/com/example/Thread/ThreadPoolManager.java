package com.example.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author majunjie
 * @description
 * @date 2017/10/25 15:14
 */
public class ThreadPoolManager {

    public static final ExecutorService pool = Executors.newCachedThreadPool();

}
