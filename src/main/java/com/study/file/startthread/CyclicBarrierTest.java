package com.study.file.startthread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用CyclicBarrier(回环栅栏)实现线程按顺序运行
 */
public class CyclicBarrierTest {

//    private static CyclicBarrier barrier1 = new CyclicBarrier(2);
//    private static CyclicBarrier barrier2 = new CyclicBarrier(2);
//
//    public static void main(String[] args) {
//        final Thread thread1 =  new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println("产品经理规划新需求");
//                    //放开栅栏1
//                    barrier1.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        final Thread thread2 =  new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //放开栅栏1
//                    barrier1.await();
//                    System.out.println("开发人员开发新需求功能");
//                    //放开栅栏2
//                    barrier2.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        final Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //放开栅栏2
//                    barrier2.await();
//                    System.out.println("测试人员测试新功能");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        System.out.println("早上：");
//        System.out.println("测试人员来上班了...");
//        thread3.start();
//        System.out.println("产品经理来上班了...");
//        thread1.start();
//        System.out.println("开发人员来上班了...");
//        thread2.start();
//    }

    /**
     * 默认的构造方法是CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线程调用await方法告诉CyclicBarrier已经到达屏障位置，线程被阻塞。
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        //final  CyclicBarrier cb = new CyclicBarrier(3);//创建CyclicBarrier对象并设置3个公共屏障点

        /**
         * 另外一个构造方法CyclicBarrier(int parties, Runnable barrierAction)，其中barrierAction任务会在所有线程到达屏障后执行。
         */
        final CyclicBarrier cb = new CyclicBarrier(3,new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "********我最先执行***********");
            }
        });
        for(int i=0;i<3;i++){
            Runnable runnable = new Runnable(){
                public void run(){
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "即将到达集合地点1，当前已有" + cb.getNumberWaiting() + "个已经到达，正在等候");
                        cb.await();//到此如果没有达到公共屏障点，则该线程处于等待状态，如果达到公共屏障点则所有处于等待的线程都继续往下运行

                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "即将到达集合地点2，当前已有" + cb.getNumberWaiting() + "个已经到达，正在等候");
                        cb.await();    //这里CyclicBarrier对象又可以重用
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "即将到达集合地点3，当前已有" + cb.getNumberWaiting() + "个已经到达，正在等候");
                        cb.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        service.shutdown();
    }


}
