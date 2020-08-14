package com.study.file.proxy.cglib;

public class CglibTest {

    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("java");
    }
}
