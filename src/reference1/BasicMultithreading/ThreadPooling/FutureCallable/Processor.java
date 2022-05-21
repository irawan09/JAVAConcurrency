package reference1.BasicMultithreading.ThreadPooling.FutureCallable;

import java.util.concurrent.Callable;

public class Processor implements Callable<String> {

    private int id;

    public Processor(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Id: "+this.id;
    }
}
