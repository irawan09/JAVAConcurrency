package reference1.BasicMultithreading.Lecture6;

import static reference1.BasicMultithreading.Lecture6.ThreadColor.ANSI_BLUE;

public class Lecture6 {

    private static int counter = 0;

    public static void main(String[] args){
        process();
        System.out.println("Counter: "+ANSI_BLUE+counter);
    }

    /*
    * Synchronized method
    * */
    public static synchronized void increment(){
        ++counter;
    }

    public static void process(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100; i++){
//                    increment();
                    counter++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<100;i++){
//                    increment();
                    counter++;
                }
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
    }
}
