package com.study.file.mywork;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author：zhoujiale
 */
public class MyThreadTest {
    //定义一个信号量
    public static Semaphore semaphore = new Semaphore(3,true);

    public static void main(String[] args) {
        //3个线程用同一个信号量

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        String name = new Thread(t1).getName();
        String name2 = new Thread(t2).getName();
        String name3 = new Thread(t3).getName();
        t1 = new MyThread(semaphore,"线程名"+name);
        t2 = new MyThread(semaphore,"线程名"+name2);
        t3 = new MyThread(semaphore,"线程名"+name3);
        new Thread(t1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        new Thread(t2).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t3).start();


    }

}
