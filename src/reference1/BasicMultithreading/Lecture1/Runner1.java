package reference1.BasicMultithreading.Lecture1;

import static reference1.BasicMultithreading.Lecture1.ThreadColor.ANSI_BLUE;

public class Runner1 {

    public void startRunning(){
        for(int i=0;i<10;i++){
            System.out.println(ANSI_BLUE+"Runner1: "+i);
        }
    }
}
