package com.study.file;


import com.study.file.obs.FileObservers;
import com.study.file.obs.Files;
import com.study.file.obs.Folder;
import com.study.file.obs.Observer;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest1
{

    @Test
    public void testFile(){
        System.out.println("============Composite Pattern===========");

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
        System.out.println("----------find()方法效果-----------");

        dir1.find();

        System.out.println("============Observer Pattern===========");
        Folder folder = new Folder();
        Observer tom = new FileObservers("tom");
        Observer jack = new FileObservers("jack");
        Observer lily = new FileObservers("lily");
        folder.registerObserver(tom);
        folder.registerObserver(jack);
        folder.registerObserver(lily);
        folder.setInfo(" file system contains dir1,dir2,dir3");

        System.out.println("----------remove()方法效果-----------");
        dir1.remove(dir3);
        folder.setInfo("file system contains dir1,dir2");

        System.out.println("----------removeObserver()方法效果-----------");
        folder.removeObserver(tom);
        folder.setInfo("file system contains dir1,dir2");
    }

    @Test
    public void testObserver(){
        testFile();
    }

    /**
     *import files or Folder
     **/
//    @Test
//    public void importFiles(){
//        System.out.println("============import d:root/dir1/=============");
//        String path = "/dir1";
//        Folder folder = new Folder("d:root",1);
//        folder.imports(path);
//
//        System.out.println("============import d:root/dir2/=============");
//        String path2 = "/dir2";
//        Folder folder2 = new Folder("d:root",1);
//        folder2.imports(path2);
//
//        System.out.println("============import f:root/file1.txt=============");
//        String file1 = "/file1.txt";
//        Folder folder3 = new Folder("f:root",1);
//        folder3.imports(file1);
//
//        System.out.println("============import f:root/dir1/file2.pdf=============");
//        String file2 = "/dir1/file2.pdf";
//        Folder folder4 = new Folder("f:root",1);
//        folder4.imports(file2);
//
//        System.out.println("============import d:root/dir2/dir3/=============");
//        String path5 = "/dir2/dir3/";
//        Folder folder5 = new Folder("f:root",1);
//        folder5.imports(path5);
//
//        System.out.println("============import f:root/dir2/dir3/file3.png=============");
//        String path6 = "/dir2/dir3/file3.png";
//        Folder folder6 = new Folder("f:root",1);
//        folder6.imports(path6);
//    }

    @Test
    public void importFilesNew(){
        System.out.println("============import Folder start=============");
        Folder folder = new Folder();
        folder.imports();
        System.out.println("============import files start=============");
        Files files = new Files();
        files.imports();

    }

}
