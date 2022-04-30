package AnotherSources.BasicMultithreading.Lecture4;

import static AnotherSources.BasicMultithreading.Lecture4.ThreadColor.ANSI_BLUE;

public class Runner1 extends Thread{

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(ANSI_BLUE+"Runner1: "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
