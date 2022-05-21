package reference1.DiningPhilosopherProblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static reference1.DiningPhilosopherProblem.ThreadColor.*;

public class ChopStick {

    private Lock lock;
    private int id;

    public ChopStick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException{
        if(this.lock.tryLock(10, TimeUnit.MILLISECONDS)){
            System.out.println(ANSI_RED+philosopher+" picked up "+state.toString()+" "+this);
            return true;
        }
        return false;
    }

    public void putDown(Philosopher philosopher, State state){
        this.lock.unlock();
        System.out.println(ANSI_BLUE+philosopher+" puts down "+this);
    }

    @Override
    public String toString() {
        return "Chopstick-"+this.id;
    }
}
