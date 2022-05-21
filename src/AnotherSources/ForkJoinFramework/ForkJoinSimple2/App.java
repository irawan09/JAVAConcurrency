package AnotherSources.ForkJoinFramework.ForkJoinSimple2;

import java.util.concurrent.ForkJoinPool;

public class App {

    public static void main(String[] args){

        ForkJoinPool forkJoinPool= new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(100);
        System.out.println(forkJoinPool.invoke(simpleRecursiveAction));

    }
}
