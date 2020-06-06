package com.study.file.obs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹
 * 被观察者
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 * @author：xxx
 */
public class Folder extends Directory implements Observerable {
    //组合模式
    //层级
    private Integer level;

    //目录集合
    private List<Directory> directoryList;
    public Folder(){}

    public Folder(String name,Integer level) {
        super(name);
        this.level = level;
        this.directoryList = new ArrayList<>();
    }

    @Override
    public void find() {
        System.out.println(this.s);
        for (Directory dir : this.directoryList) {
            //控制显示格式
            if(this.level != null){
                for(int  i = 0; i < this.level; i ++){
                    //打印空格控制格式
                    System.out.print("   ");
                }
                for(int  i = 0; i < this.level; i ++){
                    //每一行开始打印一个/号
                    if(i == 0){
                        System.out.print("/");
                    }
                    System.out.print("-");
                }
            }
            //打印名称
            dir.find();
        }
    }



//    @Override
//    public void imports(String path) {
//        System.out.println(s);
//        if(path.contains("/")){
//            String[] split = path.split("/");
//            for (int i = 0; i < split.length; i++) {
//                String str = split[i];
//                System.out.println(str);
//                if(!str.isEmpty()){
//                    if(str.subSequence(0,1).equals("d")){
//                        Folder folderD = new Folder(str,i+1);
//                        this.add(folderD);
//                    }
//                    if(str.subSequence(0,1).equals("f")){
//                        Files files = new Files(str);
//                        this.add(files);
//                    }
//                }
//
//            }
//            for (int i = 0; i < this.directoryList.size(); i++) {
//                Directory directory = this.directoryList.get(i);
//                String s1 = directory.s;
//                s = s + "/"+s1;
//            }
//            System.out.println("创建文件后获取到的路径："+s);
//        }
//
//
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

    //增加节点方法
    public boolean add(Directory dir) {
        return this.directoryList.add(dir);
    }

    //删除节点方法
    public boolean remove(Directory dir) {
        return this.directoryList.remove(dir);
    }

    //得到节点方法（用不到可以去掉）
    public Directory get(int index) {
        return this.directoryList.get(index);
    }




    //观察者模式

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!list.isEmpty())
            list.remove(observer);
    }

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
