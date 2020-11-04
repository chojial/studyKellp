package com.study.file.exception;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class InputStream {

    public static void doNotCloseResourceInTry() {
        FileInputStream inputStream = null;
        try {
            File file = new File("./tmp.txt");
            inputStream = new FileInputStream(file);
            // use the inputStream to read a file
            // do NOT do this

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *  Java 7 的 try-with-resource 语法
     */
    public static void automaticallyCloseResource() {
        File file = new File("./tmp.txt");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            // use the inputStream to read a file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
//        doNotCloseResourceInTry();
        automaticallyCloseResource();
    }
}
