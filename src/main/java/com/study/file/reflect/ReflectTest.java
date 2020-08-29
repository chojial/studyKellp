package com.study.file.reflect;

public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        Class clazz = student.getClass();
        System.out.println(clazz.getName());
        //方式二（所在通过路径-相对路径）
        Class clazz2 = Class.forName("com.study.file.reflect.Student");
        System.out.println(clazz2.getName());
        //方式三（通过类名）
        Class clazz3 = Student.class;
        System.out.println(clazz3.getName());
    }
}
