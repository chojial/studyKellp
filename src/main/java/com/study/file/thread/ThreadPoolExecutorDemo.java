package com.study.file.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private final static int CORE_POOL_SIZE = 5;
    private final static int MAX_POOL_SIZE = 10;
    private final static int QUEUE_CAPACITY = 100;
    private final static Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            MyRunnable myRunnable = new MyRunnable("" + i);
            threadPoolExecutor.execute(myRunnable);
        }
        //终止线程池
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated());
        System.out.println("Finished all threads");
    }
}
