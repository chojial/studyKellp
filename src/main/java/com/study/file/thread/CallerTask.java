package com.study.file.thread;

import java.util.concurrent.Callable;

/**
 * @author：zhoujiale
 */
public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) throws Exception {
        CallerTask callerTask = new CallerTask();
        String call = callerTask.call();
        System.out.println(call);
    }
}
