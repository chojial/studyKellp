package com.study.file.mywork;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author：zhoujiale
 */
public class MyThread implements Runnable{

    private Semaphore semaphore ;

    private String name;

    public MyThread(){

    }

    public MyThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();
            System.out.println("Thread  <" + name + ">  STARTING");
            int i = (int)(Math.random()*100+1);
            TimeUnit.SECONDS.sleep(i);
            System.out.println("Thread  <" + name + ">  ENDED");
            //释放这个线程
            semaphore.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {


        }
    }
}
