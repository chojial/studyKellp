package com.study.file;

import static org.junit.Assert.assertTrue;

import com.study.file.observer.File;
import com.study.file.observer.FileObservers;
import com.study.file.observer.Folder;
import com.study.file.observer.Observer;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testFile(){
        System.out.println("============Composite Pattern===========");

        File c = new File("C:");
        File d = new File("D:");

        Folder office = new Folder("E:",2);

        File word = new File("a.txt");
        File ppt = new File("b.txt");
        File excel = new File("c.txt");

        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder wps = new Folder("package",3);
        wps.add(new File("d.txt"));
        office.add(wps);

        Folder root = new Folder("root",1);
        root.add(c);
        root.add(d);
        root.add(office);

        System.out.println("----------find()方法效果-----------");
        root.find();

        System.out.println("============Observer Pattern===========");
        Folder folder = new Folder();
        Observer tom = new FileObservers("tom");
        Observer jack = new FileObservers("jack");
        Observer lily = new FileObservers("lily");
        folder.registerObserver(tom);
        folder.registerObserver(jack);
        folder.registerObserver(lily);
        folder.setInfo(" file system contains C,D,E disk");

        System.out.println("----------remove()方法效果-----------");
        root.remove(c);
        folder.setInfo("file system contains D,E disk");

        System.out.println("----------removeObserver()方法效果-----------");
        folder.removeObserver(tom);
        folder.setInfo("file system contains D,E disk");
    }

    @Test
    public void testObserver(){

        testFile();



    }
}
