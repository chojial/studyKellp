package com.study.file;

import com.study.file.obs.Files;
import com.study.file.obs.Folder;
import org.junit.Test;

/**
 * @author：xxx
 */
public class AppTest2 {
    @Test
    public void findFile(){
        Folder dir1 = new Folder("dir1",1);

        Folder dir2 = new Folder("dir2",2);
        Files textKey = new Files("textKey.txt");
        dir2.add(textKey);

        Folder dir3 = new Folder("dir3",2);
        Files key = new Files("Key.java");
        Files file3 = new Files("file3.pdf");
        dir3.add(key);
        dir3.add(file3);

        dir1.add(dir2);
        dir1.add(dir3);

        System.out.println("----------find(Key)方法效果-----------");
//        List<String> key1 = dir1.find("Key", null);
//        for (String str:key1) {
//            System.out.println(str);
//        }
//        System.out.println("----------find(file)方法效果-----------");
//        List<String> key2= dir2.find("file", null);
//        for (String str:key2) {
//            System.out.println(str);
//        }

    }


//    public abstract List<String> find(String s,String path);

    //查询文件夹是否有s,且返回s,如果空，返回空列表
//    @Override
//    public List<String> find(String str,String path) {
//        find();
//        System.out.println("---------查询findKey-----------");
//        String dir1 = this.s;
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < this.directoryList.size(); i++) {
//            Directory directory = this.directoryList.get(i);
//            String s1 = directory.s;
//            if(!s1.contains(str)){
//                path = dir1 + "/"+s1;
//                System.out.println(dir1);
//                List<String> strings = directory.find(str, path);
//                if(strings != null && strings.size() >0){
//                    for (String ss:strings) {
//                        list.add(ss);
//                    }
//                }
//            }else{
//                path = path + "/" + s1;
//                list.add(path);
//            }
//        }
//        System.out.println("创建文件后获取到的路径："+ path);
//        return list;
//
//    }
}
