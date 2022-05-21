package reference1.BasicMultithreading.Lecture12;

import static reference1.BasicMultithreading.Lecture12.ThreadColor.*;

public class Lecture12 {

    public static void main(String[] args){

        Counter counter = new Counter();

        Thread t1 = new Thread(counter, ANSI_BLUE+"First Thread");
        Thread t2 = new Thread(counter, ANSI_RED+"Second Thread");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ANSI_PURPLE+"Counter: "+counter.count);
    }
}

