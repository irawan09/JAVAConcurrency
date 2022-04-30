package AnotherSources.BasicMultithreading.Lecture7;

import  static AnotherSources.BasicMultithreading.Lecture7.ThreadColor.ANSI_BLUE;
import  static AnotherSources.BasicMultithreading.Lecture7.ThreadColor.ANSI_RED;
import  static AnotherSources.BasicMultithreading.Lecture7.ThreadColor.ANSI_WHITE;

public class Lecture7 {

    private static int count1 = 0;
    private static int count2 = 0;

    public static void main(String[] args){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ANSI_RED+"Count1: "+count1+ANSI_WHITE+" - "+ANSI_BLUE+"Count2: "+count2);
    }

    public synchronized static void addCount1(){
        count1++;
    }

    public synchronized static void addCount2(){
        count2++;
    }

    public static void compute(){
        for(int i=0; i<100; i++){
            addCount1();
            addCount2();
        }
    }
}
