//package com.study.file.thread;
//
//import java.util.concurrent.Callable;
//
///**
// * @author：zhoujiale
// */
//public class CallerTask<String> implements Callable<String> {
//    @Override
//    public String call() throws Exception {
//        return "hello";
//    }
//
//    public static void main(String[] args) {
//        CallerTask<String> callerTask = new CallerTask<>();
//        new Thread(callerTask).start();
//    }
//}
