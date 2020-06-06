package com.study.file.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹
 * 被观察者
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 * @author：xxx
 */
public class Folder extends Directory implements Observerable{
    //组合模式
    //层级
    private Integer level;

    //目录集合
    private List<Directory> directoryList;
    public Folder(){}

    public Folder(String name,Integer level) {
        super(name);
        this.level = level;
        this.directoryList = new ArrayList<>();
    }

    @Override
    public void find() {
        System.out.println(this.s);
        for (Directory dir : this.directoryList) {
            //控制显示格式
            if(this.level != null){
                for(int  i = 0; i < this.level; i ++){
                    //打印空格控制格式
                    System.out.print("   ");
                }
                for(int  i = 0; i < this.level; i ++){
                    //每一行开始打印一个/号
                    if(i == 0){ System.out.print("/"); }
                    System.out.print("-");
                }
            }
            //打印名称
            dir.find();
        }
    }

    //增加节点方法
    public boolean add(Directory dir) {
        return this.directoryList.add(dir);
    }

    //删除节点方法
    public boolean remove(Directory dir) {
        return this.directoryList.remove(dir);
    }

    //得到节点方法（用不到可以去掉）
    public Directory get(int index) {
        return this.directoryList.get(index);
    }




    //观察者模式

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!list.isEmpty())
            list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.write(message);
        }
    }

    //更新消息的方法
    public void setInfo(String s) {
        this.message = s;
        System.out.println("文件系统更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
