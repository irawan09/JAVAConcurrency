package another_sources.BasicMultithreading.Lecture5;

import static another_sources.BasicMultithreading.Lecture5.ThreadColor.ANSI_RED;

public class Worker implements Runnable{

    private boolean isTerminated = false;

    @Override
    public void run() {
        while (!isTerminated){
            System.out.println(ANSI_RED+"Hello from worker class...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
}
