package org.example;

/**
 * @author Praboda Thathsarani
 * @Project Threads
 */
public class main2 {
    public static void main(String[] args) {
        //create a instance of runnable
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
