package AnotherSources.BasicMultithreading.Lecture1;

import static AnotherSources.BasicMultithreading.Lecture1.ThreadColor.ANSI_RED;

public class Runner2 {

    public void startRunning(){
        for(int i=0;i<10;i++){
            System.out.println(ANSI_RED+"Runner2: "+i);
        }
    }
}
