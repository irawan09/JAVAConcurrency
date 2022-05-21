package reference2.basic_thread;

import static reference2.basic_thread.ThreadColor.*;

public class Main {

    public static void main(String[] args){
        System.out.println(ANSI_PURPLE+"Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("ANOTHER THREAD");
        anotherThread.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN+"Hello from anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED+"Hello from anonymous class implementation of run()");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED+"Another thread is terminated. So, I'm running again");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED+"I couldn't wait after all. I was interrupted");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE+"Hello again from main thread");
    }
}
