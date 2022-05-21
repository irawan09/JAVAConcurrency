package reference1.ConcurrentLibrary.CopyOnWriteArray;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class App {
    /**
     * CopyOnWriteArrayList can be used as a thread-safe alternative to ArrayList,
     * with additional methods addIfAbsent() and addAllAbsent() that append elements
     * if they are not contained in the list. A CopyOnWriteArrayList makes a new copy of its elements
     * for every write operation and its iterator holds a different copy (snapshot) so
     * it enables sequential writes and concurrent reads: only one thread can execute write
     * operation and multiple threads can execute read operations at the same time.
     * And its iterator doesn’t throw ConcurrentModification.
     */
    public static void main(String[] args){
        List<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        new WriteThread("Writer", list).start();
        new ReadThread("Reader", list).start();
    }
}
