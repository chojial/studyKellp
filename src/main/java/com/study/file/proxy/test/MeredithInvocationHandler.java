package com.study.file.proxy.test;

import java.lang.reflect.Method;

public interface MeredithInvocationHandler {

    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
