package com.study.file.exception;

import lombok.extern.slf4j.Slf4j;

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
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        doNotCloseResourceInTry();
    }
}
