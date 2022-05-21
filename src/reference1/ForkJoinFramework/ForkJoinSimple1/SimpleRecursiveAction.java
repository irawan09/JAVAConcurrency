package reference1.ForkJoinFramework.ForkJoinSimple1;

import static reference1.ForkJoinFramework.ForkJoinSimple1.ThreadColor.*;
import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private int simulateWork;

    public SimpleRecursiveAction(int simulateWork) {
        this.simulateWork = simulateWork;
    }

    @Override
    protected void compute() {
        if(simulateWork>100){
            System.out.println(ANSI_RED+"Parallel execution and split the tasks... "+simulateWork);
        } else{
            System.out.println(ANSI_BLUE+"No need for parallel execution, sequential is OK for computation... "+simulateWork);
        }
    }
}
