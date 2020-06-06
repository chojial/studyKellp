package com.study.file.mywork;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author：xxx
 */
public class Executor extends Thread{

    //以semaphore0开始的信号量，初始信号量为1
    public static Semaphore semaphore0 = new Semaphore(1,true);
    public static Semaphore semaphore01 = new Semaphore(0);
    public static Semaphore semaphore12 = new Semaphore(0);
    public static Semaphore semaphore13 = new Semaphore(0);
    public static Semaphore semaphore23 = new Semaphore(0);
    public static Semaphore semaphore25 = new Semaphore(0);
    public static Semaphore semaphore4 = new Semaphore(1,true);
    public static Semaphore semaphore43 = new Semaphore(0);
    public static Semaphore semaphore45 = new Semaphore(0);

    public  Executor(boolean [][] precedences,Runnable []  tasks){
        for (int i = 0; i < precedences.length; i++) {
            for (int j = 0; j < precedences[i].length; j++) {
                //如果precedences[i][j] 是true,表示j不能开始在i结束之前
//                if(precedences[i][j]){
//                    new Task0().start();
//                    new Task1().start();
//                    new Task2().start();
//                    new Task3().start();
//                    new Task4().start();
//                    new Task5().start();
//                i=1j=2   true
//                i=1j=3   true
//                i=2j=3   true
//                i=2j=5   true
//                i=4j=3   true
//                i=4j=5   true
//                }
                //当precedences为true时，才做处理
                if(precedences[i][j]){

                    Runnable task = tasks[0];
                    new Thread(task).start();
                    Runnable task1 = tasks[1];
                    new Thread(task1).start();
                    Runnable task2 = tasks[2];
                    new Thread(task2).start();
                    Runnable task3 = tasks[3];
                    new Thread(task3).start();
                    Runnable task4 = tasks[4];
                    new Thread(task4).start();
                    Runnable task5 = tasks[5];
                    new Thread(task5).start();





//                    System.out.println("i="+ i + "j=" + j + "   " + precedences[i][j]);
//                    if(i == 0 && j == 1){
////                        System.out.println("i="+ i + "j=" + j +"-start---------");
//                        Runnable task = tasks[0];
//                        new Thread(task).start();
//                        Runnable task1 = tasks[1];
//                        new Thread(task1).start();
////                        System.out.println("i="+ i + "j=" + j +"-end---------");
//                    }
//                    if(i == 1 && j == 2){
//                        Runnable task = tasks[0];
//                        new Thread(task).start();
//                        Runnable task1 = tasks[1];
//                        new Thread(task1).start();
//                        Runnable task2 = tasks[2];
//                        new Thread(task2).start();
//                    }
//                    if(i == 1 && j == 3){
//                        System.out.println("i="+ i + "j=" + j +"-start---------");
//                        Runnable task = tasks[0];
//                        new Thread(task).start();
//                        Runnable task1 = tasks[1];
//                        new Thread(task1).start();
//                        Runnable task3 = tasks[3];
//                        new Thread(task3).start();
//                        System.out.println("i="+ i + "j=" + j +"-end---------");
//                    }
//                    if(i == 1 && j == 2){
//
//                    }
//                    if(i == 1 && j == 2){
//
//                    }
//                    if(i == 1 && j == 2){
//
//                    }
//                    for (int k = 0; k < tasks.length; k++) {
//                        System.out.println("k="+tasks[k]);
//
//                    }
                }

            }
        }
    }

    //获取随机数1-100
    public static void getRandom(){
        //随机数1-100
        int i = (int)(Math.random()*100+1);
        try {
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task0 extends Thread{
        public Task0(){}
        @Override
        public void run() {
            try{
                semaphore0.acquire();
                System.out.println("TASK 0：started");
                getRandom();
                System.out.println("TASK 0：finished");
                semaphore01.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class Task1 extends Thread{
        public Task1(){}
        @Override
        public void run() {
            try{
                semaphore01.acquire();
                System.out.println("TASK 1：started");
                getRandom();
                System.out.println("TASK 1：finished");
                semaphore12.release();
                semaphore13.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class Task2 extends Thread{

        public Task2(){}

        @Override
        public void run() {
            try{
                semaphore12.acquire();
                semaphore13.acquire();
                System.out.println("TASK 2：started");
                getRandom();
                System.out.println("TASK 2：finished");

                semaphore23.release();
                semaphore25.release();
                semaphore0.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class Task3 extends Thread{
        public Task3(){}
        @Override
        public void run() {
            try{
                semaphore23.acquire();
                System.out.println("TASK 3：started");
                getRandom();
                System.out.println("TASK 3：finished");
                semaphore0.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class Task4 extends Thread{

        public Task4(){}

        @Override
        public void run() {
            try{
                semaphore4.acquire();
                System.out.println("TASK 4：started");
                getRandom();
                System.out.println("TASK 4：finished");
                semaphore43.release();
                semaphore45.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class Task5 extends Thread{
        public Task5(){}
        @Override
        public void run() {
            try{
                semaphore25.acquire();
                semaphore45.acquire();
                System.out.println("TASK 5：started");
                getRandom();
                System.out.println("TASK 5：finished");
//                semaphore0.release();
//                semaphore4.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Task0().start();
        new Task1().start();
        new Task2().start();
        new Task3().start();
        new Task4().start();
        new Task5().start();

    }
}
