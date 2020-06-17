package com.study.file.chain;

/**
 *@author zhoujiale
 *@date 2020-06-17 21:56:00
 * 记录器类
 **/


public abstract class AbstractLogger {

    static int INFO = 1;
    static int DEBUG = 2;
    static int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public AbstractLogger getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level,String message){
        if(this.level<=level){
            write(message);
        }
        if(nextLogger != null){
            nextLogger.logMessage(level,message);
        }
    }

    abstract protected void write(String message);
}
