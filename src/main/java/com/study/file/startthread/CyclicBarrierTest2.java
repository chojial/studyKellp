package com.study.file.startthread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest2 {


    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            //当await方法返回后，就回执行，在哪个线程返回的就是在哪个线程执行这个任务
            System.out.println(Thread.currentThread() + "task1 merge result");
        }
    });

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "task1-1");
                    System.out.println(Thread.currentThread() + "enter in barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "enter out barrier");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "task1-2");
                    System.out.println(Thread.currentThread() + "enter in barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "enter out barrier");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();


    }
}
