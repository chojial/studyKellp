//package com.study.file.thread;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.FutureTask;
//
///**
// * @author：zhoujiale
// */
//public class FutureTask {
//
//    public FutureTask() {
//    }
//
//    public static class CallerTask implements Callable<String>{
//
//        @Override
//        public String call() throws Exception {
//            return "hello";
//        }
//
//        public CallerTask() {
//        }
//
//
//    }
//
//    public static void main(String[] args) throws InterruptedException{
//        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
//        new Thread(futureTask).start();
//        try{
//
//        }
//    }
//}
