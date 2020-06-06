package com.study.file.observer;

/**
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * @author：xxx
 */
public interface Observerable {

    //添加
    void registerObserver(Observer o);
    //删除
    void removeObserver(Observer o);
    //通知
    void notifyObserver();
}
