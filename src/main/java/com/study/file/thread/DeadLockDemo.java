package com.study.file.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {

    private static volatile Lock resource1  = new ReentrantLock();
    private static volatile Lock resource2  = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(()->{
            resource1.lock();
            System.out.println(Thread.currentThread() + "get resource1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "waiting get resource2");
            resource2.lock();
            System.out.println(Thread.currentThread() + "get resource2");
//            resource1.unlock();
//            System.out.println(Thread.currentThread() + "resource1.unlock()");
        },"线程 1").start();


        new Thread(()->{
            resource2.lock();
            System.out.println(Thread.currentThread() + "get resource2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "waiting get resource1");
            resource1.lock();
            System.out.println(Thread.currentThread() + "get resource1");
//            resource2.unlock();
//            System.out.println(Thread.currentThread() + "resource2.unlock()");
        },"线程 2").start();

    }
}
