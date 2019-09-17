package com.shark.common;

import java.util.concurrent.*;

/**
 * 线程池工具类
 *
 * @author sharkeatshark@foxmail.com
 * @create 2019-07-29-11:05
 * @projectName SharkUtils
 * @packageName com.shark.common
 */
public class ThreadPoolFactory {

    /**
     * @return
     */
    public static ThreadPoolExecutor getThreadPoolExecutor() {
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
//        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//
//        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
//        singleThreadPool.shutdown();

//todo 线程池
//        ThreadPoolExecutor tpe = new ThreadPoolExecutor();

        return null;


    }

}
