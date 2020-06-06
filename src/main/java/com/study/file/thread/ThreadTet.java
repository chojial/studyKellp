package com.study.file.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author：zhoujiale
 */
public class ThreadTet {

//    public static class MyThread extends Thread{
//        @Override
//        public void run(){
//            System.out.println("I am a child Thread");
//        }
//    }
//
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//    }




    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello";
        }

    }

    public static void main(String[] args) throws InterruptedException{
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try{
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



}
