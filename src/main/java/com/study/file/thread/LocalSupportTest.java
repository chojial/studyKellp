package com.study.file.thread;

import java.util.concurrent.locks.LockSupport;

public class LocalSupportTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("child thread begin park");

                //挂起自己
////                LockSupport.park();

                //调用park，挂起自己，只有被中断才会退出循环
                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }
                System.out.println("child thread end park");
            }
        });

        thread.start();

        //主线程休眠
        Thread.sleep(1000);

        System.out.println("main thread begin unpark");
        //调用unpark方法让thread持有许可证，然后park返回
//        LockSupport.unpark(thread);

        //中断子线程
        thread.interrupt();
    }
}
