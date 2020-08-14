package com.study.file.proxy;


public class DebugProxy {

    public static void main(String[] args) {
        Object proxy = JdkProxyFactory.getProxy(new SmsServiceImpl());
        SmsService smsService = (SmsService) proxy;
        smsService.send("java");
    }

}
