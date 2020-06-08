package com.study.file.thread;

/**
 * 双重校验锁实现对象单例（线程安全）
 */
public class DoubleCheckTest {

    private volatile static DoubleCheckTest singleton ;

    private DoubleCheckTest(){

    }

    public synchronized static DoubleCheckTest getSingleton(){
        //先判断对象是否已经实例过，没有实例化过才进入锁代码
        if(singleton == null){
            //类对象枷锁
            synchronized (DoubleCheckTest.class){
                if(singleton == null){
                    singleton = new DoubleCheckTest();
                }
            }
        }
        return singleton;
    }


}
