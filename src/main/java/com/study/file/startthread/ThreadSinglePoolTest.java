package com.study.file.startthread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过SingleThreadExecutor让线程按顺序执行
 */
public class ThreadSinglePoolTest {

    /**
     * 单线程化线程池(newSingleThreadExecutor);
     * 可控最大并发数线程池(newFixedThreadPool);
     * 可回收缓存线程池(newCachedThreadPool);
     * 支持定时与周期性任务的线程池(newScheduledThreadPool)。
     */

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        Thread thread1 = new Thread(()-> System.out.println("产品经理规划新需求"));
        Thread thread2 = new Thread(()-> System.out.println("开发人员开发新需求功能"));
        Thread thread3 = new Thread(()-> System.out.println("测试人员测试新功能"));

        System.out.println("早上：");
        System.out.println("产品经理来上班了");
        System.out.println("测试人员来上班了");
        System.out.println("开发人员来上班了");
        System.out.println("领导吩咐:");
        System.out.println("首先，产品经理规划新需求...");
        executorService.submit(thread1);
        System.out.println("然后，开发人员开发新需求功能...");
        executorService.submit(thread2);
        System.out.println("最后，测试人员测试新功能...");
        executorService.submit(thread3);
        executorService.shutdown();
    }
}
