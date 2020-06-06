package com.study.file.mywork;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author：xxx
 */
public class SemaphoreTest {

    //以semaphore1开始的信号量，初始信号量为1
    private static Semaphore semaphore1 = new Semaphore(1,true);

    //semaphore2,semaphore3信号量，semaphore1完成后开始，初始信号量为0
    private static Semaphore semaphore2 = new Semaphore(0);
    private static Semaphore semaphore3 = new Semaphore(0);

    //获取随机数1-100
    public static void getRandom(){
        //随机数1-100
        int i = (int)(Math.random()*100+1);
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            try {
                //1获取信号执行
                semaphore1.acquire();
                System.out.println("Thread  <" + Thread.currentThread().getName() + ">  STARTING");
                //随机数1-100
                getRandom();
                System.out.println("Thread  <" + Thread.currentThread().getName() + ">  ENDED");
                //2释放信号，2信号量为1，可以执行
                semaphore2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                //2获取信号执行
                semaphore2.acquire();
                System.out.println("Thread  <" + Thread.currentThread().getName() + ">  STARTING");
                //随机数1-100
                getRandom();
                System.out.println("Thread  <" + Thread.currentThread().getName() + ">  ENDED");
                //3释放信号，3信号量为1，可以执行
                semaphore3.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread3 extends Thread{
        @Override
        public void run() {
            try {
                semaphore3.acquire();
                System.out.println("Thread  <" + Thread.currentThread().getName() + ">  STARTING");
                //随机数1-100
                getRandom();
                System.out.println("Thread  <" + Thread.currentThread().getName() + ">  ENDED");
                //释放这个线程
                semaphore1.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        //顺序打印123
        new Thread1().start();
        new Thread2().start();
        new Thread3().start();
    }

}
