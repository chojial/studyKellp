package com.study.file.thread.threadLock;

/**
 * 子线程需要使用存放在threadLocal变量中的用户登陆信息；
 * 中间件需要把统一的id追踪的整个调用链路记录下来
 */
public class ThreadLocalTest {

    //子线程可以拿到父线程的threadLocal变量
    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    //子线程不NO可以拿到父线程的threadLocal变量
//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("you have bug");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                threadLocal.set("nibuhao");
                System.out.println("thread children:" + threadLocal.get());
            }
        });
        thread.start();
        System.out.println("main:"+threadLocal.get());
    }
}
