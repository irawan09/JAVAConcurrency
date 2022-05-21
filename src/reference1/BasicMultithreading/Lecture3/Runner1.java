package reference1.BasicMultithreading.Lecture3;

import static reference1.BasicMultithreading.Lecture3.ThreadColor.ANSI_BLUE;

public class Runner1 extends Thread {

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(ANSI_BLUE+"Runner1: "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
