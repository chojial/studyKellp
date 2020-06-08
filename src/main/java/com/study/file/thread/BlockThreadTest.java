package com.study.file.thread;

import java.util.concurrent.TimeUnit;

public class BlockThreadTest {

    public static void main(String[] args) {


        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"status_01").start();//阻塞状态

        new Thread(()->{
            while(true){
                synchronized (BlockThreadTest.class){
                    try {
                        BlockThreadTest.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"STATUS_02").start(); //阻塞状态

        new Thread(new BlockedDemo(),"thread-01").start();//timed_waiting
        new Thread(new BlockedDemo(),"thread-02").start();//blocked

    }


    public static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
