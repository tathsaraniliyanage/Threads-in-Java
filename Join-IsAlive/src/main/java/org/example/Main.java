package org.example;

import javax.swing.*;

/**
 * @author Praboda Thathsarani
 * @Project Default (Template) Project
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
       Thread t1 = new Thread(()->{
           for(int i=1; i<=5 ; i++){
               System.out.println("THread One");
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       });

        Thread t2 = new Thread(()->{
            for(int i=1; i<=5 ; i++){
                System.out.println("THread Two");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        t1.join();
        t2.join();
        System.out.println("BYE");
    }
}