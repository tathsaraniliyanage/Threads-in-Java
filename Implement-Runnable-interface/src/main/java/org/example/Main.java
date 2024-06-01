package org.example;

/**
 * @author Praboda Thathsarani
 * @Project Default (Template) Project
 */// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       Runnable one = new One();
       Runnable two = new Two();
       Thread t1= new Thread(one);
       Thread t2= new Thread(two);
       t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}

class One implements Runnable{
    public void run(){
for(int i=1;i<=5;i++){
    System.out.println("Thread one");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new  RuntimeException(e);
    }
}
    }
}

class Two implements Runnable{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Thread two");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}