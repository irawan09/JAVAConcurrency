package AnotherSources.ForkJoinFramework.ForkJoinSimple2;

import static AnotherSources.ForkJoinFramework.ForkJoinSimple2.ThreadColor.*;
import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveAction extends RecursiveTask<Integer> {

    private int simulateWork;

    public SimpleRecursiveAction(int simulateWork) {
        this.simulateWork = simulateWork;
    }

    @Override
    protected Integer compute() {
        if(simulateWork>100){
            System.out.println(ANSI_RED+"Parallel exexcution and split the tasks... "+simulateWork);

            SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simulateWork/2);
            SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simulateWork/2);

            int solution  =0;
            solution = solution + simpleRecursiveAction1.join();
            solution = solution + simpleRecursiveAction2.join();

            return solution;
        } else {
            System.out.println(ANSI_BLUE+"No need Parallel execution, sequential is OK for this tasks...");
            return 2*simulateWork;
        }

    }
}
