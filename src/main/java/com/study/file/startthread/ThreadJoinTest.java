package com.study.file.startthread;

/**
 * 通过子程序join使线程按顺序执行
 */
public class ThreadJoinTest{


    public static void main(String[] args) {


        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("产品经理规划新需求");

            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开发人员开发新需求功能");

            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("测试人员测试新功能");

            }
        });

        System.out.println("早上：");
        System.out.println("测试人员来上班了...");

        System.out.println("产品经理来上班了...");
        thread2.start();
        System.out.println("开发人员来上班了...");
        thread3.start();
        thread1.start();
        //thread123顺序没有要求
    }

}
