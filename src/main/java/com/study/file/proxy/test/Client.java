package com.study.file.proxy.test;

public class Client {

    public static void main(String[] args) {

        Proxy proxy = new Proxy(new Proxy.RealSubject());
        proxy.request();

    }

    interface ISubject{
        void request();
    }

    static class Proxy implements ISubject{

        private ISubject iSubject;

        public Proxy(ISubject iSubject) {
            this.iSubject = iSubject;
        }

        public void request(){
            before();
            iSubject.request();
            after();

        }

        public void before(){
            System.out.println("called before request().");
        }

        public void after(){
            System.out.println("called after request().");
        }

        static class RealSubject implements ISubject{
            public void request(){
                System.out.println("real ISubject is called.");
            }

        }
    }
}
