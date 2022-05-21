package reference2.concurrent_package;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static reference2.concurrent_package.Main.EOF;

public class MyConsumer implements Runnable{

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buff, String col, ReentrantLock buffLock){
        this.buffer = buff;
        this.color = col;
        this.bufferLock = buffLock;
    }

    @Override
    public void run() {
        int counter=0;
        while (true){
            if (bufferLock.tryLock()){
                try {
                    if(buffer.isEmpty()){
                        continue;
                    }
                    System.out.println(color+"The counter = "+counter);
                    if (buffer.get(0).equals(EOF)){
                        System.out.println(color+"Exiting");
                        break;
                    } else {
                        System.out.println(color+"Removed "+buffer.remove(0));
                    }
                }finally {
                    bufferLock.unlock();
                }
            } else{
                counter++;
            }
        }
    }
}
