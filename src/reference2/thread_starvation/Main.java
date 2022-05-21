package reference2.thread_starvation;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    // Fair Lock = The constructor for this class accepts an optional fairness parameter.
    // When set true, under contention, locks favor granting access to the longest-waiting thread.
    // https://hitansu166.wordpress.com/2015/05/17/fair-lock-in-java/
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args){
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        // setPriority() = method of thread class is used to change the thread's priority.
        // Every thread has a priority which is represented by the integer number between 1 to 10.
        // https://www.javatpoint.com/java-thread-setpriority-method

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static class Worker implements Runnable {
        private int runCount =1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i =0; i<100; i++){
                // Instead of using synchronous block, it's better to use Reentrant lock with fair lock feature
                // to make the setPriority method of the execution of the thread working properly. With fair lock
                // feature the waiting time of executing time will be longer than the normal object executing time
                // so the method setPriority will be working properly.
                lock.lock();
                try{
                    System.out.format(threadColor+"%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
                }finally {
                    lock.unlock();
                }



            }
        }
    }
}
