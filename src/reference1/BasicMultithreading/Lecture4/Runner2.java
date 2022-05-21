package reference1.BasicMultithreading.Lecture4;

import static reference1.BasicMultithreading.Lecture4.ThreadColor.ANSI_RED;

public class Runner2 extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(ANSI_RED+"Runner2: "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
