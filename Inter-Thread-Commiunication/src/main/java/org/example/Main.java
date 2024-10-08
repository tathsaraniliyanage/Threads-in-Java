//package org.example;
//
///**
// * @author Praboda Thathsarani
// * @Project Default (Template) Project
// */
//public class Main {
//    public static void main(String[] args) {
//         Q q = new Q();
//         new Producer(q);
//        new Consumer(q);
//    }
//}
//
//class Q{
//    int num;
//    boolean value=false;
//    public synchronized  void put(int num) {
//        while (value) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            this.num = num;
//            value = true;
//            notify();
//        }
//    }
//    public synchronized  void get(){
//        while(!value){
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println("GET: " + num);
//        value=false;
//        notify();
//    }
//}
//
//
//class Producer implements   Runnable{
//    Q q;
//    public Producer(Q q){
//        this.q=q;
//        Thread t1=new Thread(this,"producer");
//        t1.start();
//    }
//    @Override
//    public void run(){
//        int i=0;
//        while(true){
//            q.put(i++);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
//
//
//
//class Consumer implements   Runnable{
//    Q q;
//    public Consumer(Q q){
//        this.q=q;
//        Thread t1=new Thread(this,"consumer");
//        t1.start();
//    }
//    @Override
//    public void run(){
//        int i=0;
//        while(true){
//            q.get();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}






package org.example;


class Q{
    int num;
    boolean value =false;
    public synchronized void put(int num){
        while (value){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Put:" + num);
        this.num = num;
        value=true;
        notify();
    }
    public synchronized void get(){
        while (!value){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Get:" +num);
        value = false;
        notify();
    }

}
class Producer implements Runnable{
    Q q;

    public Producer(Q q){
        this.q =q;
        Thread t1 = new Thread(this,"Producer");
        t1.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



class Consumer implements Runnable{
    Q q;

    public Consumer(Q q){
        this.q =q;
        Thread t1 = new Thread(this,"producer");
        t1.start();
    }

    @Override
    public void run() {
        int i =0;
        while (true){
            q.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

public class Main {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
