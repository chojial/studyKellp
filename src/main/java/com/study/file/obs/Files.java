package com.study.file.obs;


import java.io.*;

/**
 * 文件
 * 被观察者
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 * @author：xxx
 */
public class Files extends Directory implements Observerable {

    public Files(String s) {
        super(s);
    }

    @Override
    public void find() {
        System.out.println(this.s);
    }

//    @Override
//    public void imports(String path) {
//        System.out.println(this.s);
//    }

    @Override
    public void imports() {
        //读取test下的配置文件，配置文件中的路径可以自己随意改动
        String rootPath=this.getClass().getResource("/propertis/a.txt").getFile().toString();
        InputStream is = null;
        try {
            is = new FileInputStream(rootPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String s="";
        try {
            while((s=br.readLine())!=null)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Files(){
        super();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!list.isEmpty())
            list.remove(observer);
    }
    //遍历
    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.write(message);
        }
    }

    //更新消息的方法
    public void setInfo(String s) {
        this.message = s;
        System.out.println("文件系统更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
