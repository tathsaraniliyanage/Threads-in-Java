package org.example;

/**
 * @author Praboda Thathsarani
 * @Project Default (Template) Project
 */

public class Main {
    public static void main(String[] args) {
       MyThread myThread = new MyThread();
       myThread.start();
    }
}
 class MyThread extends Thread{
    public  void run(){
        System.out.println("My First Thread");
    }
}