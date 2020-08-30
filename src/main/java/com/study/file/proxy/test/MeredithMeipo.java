package com.study.file.proxy.test;

import java.lang.reflect.Method;

public class MeredithMeipo implements MeredithInvocationHandler{

    private IPerson target;

    public IPerson getInstance(IPerson target){
        this.target = target;
        Class clazz = target.getClass();
        return (IPerson) MeredithProxy.newProxyInstance(new MeredithClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    public void before(){
        System.out.println("我是媒婆，已经收集到你的需求，开始物色");
    }

    public void after(){
        System.out.println("双方同意，开始交往");
    }
}
