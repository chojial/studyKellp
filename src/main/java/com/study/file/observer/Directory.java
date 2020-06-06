package com.study.file.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * 文件目录（根目录，最顶层）
 * @author：xxx
 */
public abstract class Directory {

    //组合模式相关属性方法
    //composite pattern

    protected String s;

    public Directory(String s){
        this.s = s;
    }

    public abstract void find();



    //观察者模式相关属性方法
    //observer pattern

    //注意到这个List集合的泛型参数为Observer接口
    public List<Observer> list;

    //文件或者文件夹更新消息
    public String message;

    public Directory(){
        list = new ArrayList<>();
    }




}
