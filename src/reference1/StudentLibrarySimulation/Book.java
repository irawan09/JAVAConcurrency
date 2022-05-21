package reference1.StudentLibrarySimulation;

import static reference1.StudentLibrarySimulation.ThreadColor.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    private int id;
    private Lock lock;

    public Book(int id) {
        this.lock = new ReentrantLock();
        this.id = id;
    }

    public void read(Student student) throws InterruptedException{
        lock.tryLock(10, TimeUnit.MILLISECONDS);
        System.out.println(ANSI_BLUE+student+" starts reading"+this);
        Thread.sleep(2000);
        lock.unlock();
        System.out.println(ANSI_RED+student+" has finished reading"+this);
    }

    @Override
    public String toString() {
        return "Book"+id;
    }
}
