package com.study.file.list;

/**
 * 测试MyDoubleLink
 * @author：xxx
 */
public class MyDoubleLinkTest {

    // 双向链表操作int数据
    private static void int_test() {
        int[] iarr = {10, 20, 30, 40};

        System.out.println("\n----增加一个节点----");
        // 创建双向链表
        MyDoubleLink<Integer> dlink = new MyDoubleLink<Integer>();

        dlink.insert(0, 20);    // 将 20 插入到第一个位置
        // 打印出全部的节点
        for (int i=0; i<dlink.size(); i++)
            System.out.println("dlink("+i+")="+ dlink.get(i));

        //指定在第2个节点前后插入新节点
        System.out.println("\n----指定在节点前后插入新节点----");
        dlink.insert(0,10);
        dlink.insert(1,30);

        // 双向链表的大小
        System.out.printf("size()=%d\n", dlink.size());
        // 打印出全部的节点
        for (int i=0; i<dlink.size(); i++)
            System.out.println("dlink("+i+")="+ dlink.get(i));


        //删除一个节点
        dlink.del(0);
        dlink.del(1);
        System.out.println("\n----删除指定节点（20）前后节点----");
        // 打印出全部的节点
        for (int i=0; i<dlink.size(); i++)
            System.out.println("dlink("+i+")="+ dlink.get(i));

        System.out.println("\n----删除自身节点----");
        //删除自身节点
        dlink.del(0);

        // 打印出全部的节点
        for (int i=0; i<dlink.size(); i++)
            System.out.println("dlink("+i+")="+ dlink.get(i));


    }

    public static void main(String[] args) {
        int_test();
    }
}
