package com.study.file.thread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 响应中断
 */
public class ReentrantLockTest2 {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadDemo(lock1,lock2));
        Thread thread2 = new Thread(new ThreadDemo(lock1,lock2));
        thread1.start();
        thread2.start();
        thread1.interrupt();//是第一个线程中断
    }
}
