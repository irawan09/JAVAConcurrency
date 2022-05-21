package reference1.ForkJoinFramework.ForkJoinSimple1;

import java.util.concurrent.ForkJoinPool;

public class App {


    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(400);
        forkJoinPool.invoke(simpleRecursiveAction);
    }
}
