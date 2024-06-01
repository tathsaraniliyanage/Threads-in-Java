package org.example;

/**
 * @author Praboda Thathsarani
 * @Project Default (Template) Project
 */
public class Main {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}


class  MyRunnable implements  Runnable{
    @Override
    public void run(){
        System.out.println("Thread is running!");
    }
}