package reference2.live_lock;

public class Main {

    public static void main(String[] args){
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResources sharedResources = new SharedResources(worker1);


        // live_lock occurs because two or more threads keep on transferring states between one another.
        new Thread(() -> worker1.work(sharedResources, worker2)).start();
        new Thread(() -> worker2.work(sharedResources, worker1)).start();
    }
}
