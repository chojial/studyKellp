package com.study.file.thread;

public class Test {

    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }


}
