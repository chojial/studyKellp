package com.study.file.proxy.test;

public class MeredithTest {

    public static void main(String[] args) {
        MeredithMeipo meredithMeipo = new MeredithMeipo();
        IPerson san = meredithMeipo.getInstance(new ZhangSan());
        san.findLove();

    }
}
