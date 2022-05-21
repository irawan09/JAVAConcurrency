package reference2.deadlocks;

public class Main {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args){
        //deadlock occurs because of two or more threads wait forever for a lock or resource held
        // by another of the threads.
        new Thread1().start();
        new Thread2().start();

    }

    private static class Thread1 extends Thread{

        public void run(){
            synchronized (lock1){
                System.out.println("Thread 1: Has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                System.out.println("Thread 1: Waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread 1: has lock1 and lock2");
                }
                System.out.println("Thread 1 : Released lock2");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread{
        public void run(){
            synchronized (lock2){
                System.out.println("Thread 2: has lock2");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                System.out.println("Thread 2: Waiting for lock1");
                synchronized (lock1){
                    System.out.println("Thread 2: has lock2 and lock1");
                }
                System.out.println("Thread 2: released lock1");
            }
            System.out.println("Thread 2: Released lock2. Exiting...");
        }
    }
}



