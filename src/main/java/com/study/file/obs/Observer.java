package com.study.file.obs;

/**
 * 抽象观察者
 * 定义了一个write()方法，当被观察者调用notifyObservers()方法时，
 * 观察者的write()方法会被回调。
 * @author：xxx
 */
public interface Observer {

    //写操作，改变文件系统内容操作
    void write(String message);

}
