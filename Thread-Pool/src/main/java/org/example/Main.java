package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Praboda Thathsarani
 * @Project Default (Template) Project
 */
public class Main {
    public static void main(String[] args) {

    }
}

 class MyRunnable implements Runnable{
     private String name;
     public  MyRunnable(String name){
         this.name=name;
     }
     @Override
     public void run() {
         System.out.println("Start Thread : " + name);
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         System.out.println("End Thread : " + name);
     }
 }


 class Demo {
     public static void main(String[] args) {
         ExecutorService executorService = Executors.newFixedThreadPool(5);
         for (int i = 0; i < 10; i++) {
             Runnable runnable = new MyRunnable("worker Thread : " + i);
             executorService.execute(runnable);
         }
         executorService.shutdown();
         while (executorService.isTerminated()) {}
         System.out.println("Success");
     }
 }