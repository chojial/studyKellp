package com.study.file.obs;

/**
 * 观察者
 * 实现了write方法
 * @author：xxx
 */
public class FileObservers implements Observer {

    private String name;
    private String message;

    public FileObservers(String name) {
        this.name = name;
    }

    @Override
    public void write(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " Received push message： " + message);
    }
}
