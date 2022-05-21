package reference1.ConcurrentLibrary.CopyOnWriteArray;

import java.util.List;

import static reference1.ConcurrentLibrary.CopyOnWriteArray.ThreadColor.*;

public class WriteThread extends Thread {

    private List<Integer> list;

    public WriteThread(String name, List<Integer> list){
        this.list = list;
        super.setName(name);
    }

    public void run(){
        int count = 6;

        while(true){
            try {
                Thread.sleep(5000);
                list.add(count++);
                System.out.println(ANSI_BLUE+super.getName()+" done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
