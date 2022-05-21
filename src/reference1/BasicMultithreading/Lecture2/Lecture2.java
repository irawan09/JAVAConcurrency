package reference1.BasicMultithreading.Lecture2;

import static reference1.BasicMultithreading.Lecture2.ThreadColor.ANSI_BLUE;
import static reference1.BasicMultithreading.Lecture2.ThreadColor.ANSI_RED;

public class Lecture2 {

    public static void main(String[] args){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10;i++){
                    System.out.println(ANSI_BLUE+"Runner1: "+i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10;i++){
                    System.out.println(ANSI_RED+"Runner2: "+i);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
