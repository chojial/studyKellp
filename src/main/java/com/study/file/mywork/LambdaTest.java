package com.study.file.mywork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：xxx
 */
public class LambdaTest {

    public static void main(String[] args) {

        List<Thread> list = new ArrayList<>();
        for(int i = 0;i < 5;i++){
            //这个name可以改动，传入不同的name得到不同的名字
            final String name = "Joey";
            //lambda表达式，内部循环打印
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 4 ; j++) {
                    System.out.println("ThreadName：" + Thread.currentThread().getName() + ", Hello I am " + name + "  " + j);
                }
            }
            );
            list.add(thread);
        }
        executor(list);
    }

    public static void executor(List<Thread> list){
        if(list != null && list.size() > 0){
            //在循环中启动多线程
            for(Thread thread :list){
                thread.start();
            }
        }
    }
}
