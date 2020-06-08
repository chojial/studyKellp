package com.study.file.thread;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 迭代器弱一致性
 * CopyOnWrite并发容器用于读多写少的并发场景
 * 比如白名单，黑名单，商品类目的访问和更新场景
 *
 * 不用加什么读写锁，锁统统给我去掉，有锁就有问题，有锁就有互斥，有锁就可能导致性能低下，你阻塞我的请求，导致我的请求都卡着不能执行。
 */
public class CopyList {

    /**
     * CopyOnWrite容器有很多优点，但是同时也存在两个问题，即内存占用问题和数据一致性问题。
     * 数据一致性问题。CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性。
     * 所以如果你希望写入的的数据，马上能读到，请不要使用CopyOnWrite容器。
     */
    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("shanghai");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1,"yes");
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });
        //保证在修改线程启动前获取迭代器
        Iterator<String> iterator = arrayList.iterator();

        //获取迭代器的操作必须在子线程操作之前进行
        thread.start();

        thread.join();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
