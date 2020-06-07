package com.study.file.product;

import java.util.Queue;

/**
 * @author：zhoujiale
 */
public class Product implements Runnable{

    private Queue<String> msg;

    private int maxSize;

    public Product(Queue<String> msg,int maxSize){
        this.maxSize = maxSize;
        this.msg = msg;
    }

    @Override
    public void run() {
        int i = 0;

        while (true){
            i++;
            synchronized (msg){
                while (msg.size() == maxSize){
                    //如果生产满了
                    try {
                        //一定会释放锁.
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者生产消息:"+i);
                msg.add("生产消息" + i);
                msg.notify(); //唤醒处于阻塞状态下的线程
                msg.notifyAll();
            }
        }
    }
}
