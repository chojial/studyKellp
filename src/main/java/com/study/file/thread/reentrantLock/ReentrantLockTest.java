package com.study.file.thread.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
//        new Thread(()->test(),"线程A").start();
//        new Thread(()->test(),"线程B").start();
        new Thread(()->fairTest(),"线程A").start();
        new Thread(()->fairTest(),"线程B").start();
        new Thread(()->fairTest(),"线程C").start();
        new Thread(()->fairTest(),"线程D").start();
    }

    public static void test(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

    private static final Lock fairLock = new ReentrantLock(true);

    /**
     * 可重入锁---公平锁
     */
    public static void fairTest(){
        for(int i = 0;i<2;i++){
            try{
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() +  "--" + i + "获取了锁");
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
//                System.out.println(Thread.currentThread().getName() + "释放了锁");
                fairLock.unlock();
            }
        }

    }
}
