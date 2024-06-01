package org.example;

/**
 * @author Praboda Thathsarani
 * @Project Default (Template) Project
 */

class Calculation{
    int num;
    public synchronized void increment(){
        num++;
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calculation c = new Calculation();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
//                System.out.println("Thread One");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
//                System.out.println("Thread Two");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.num);
    }
}





