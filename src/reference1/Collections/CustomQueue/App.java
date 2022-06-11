package reference1.Collections.CustomQueue;

import static reference1.Collections.ThreadColor.*;

public class App {

    public static void main(String[] args) {

        QueueFun<String> q = QueueFun.queue();

        QueueFun<String> enqueue = q.enqueue("Hey").enqueue(" How are you?").enqueue(" Fine?");

        System.out.println(ANSI_BLUE);
        enqueue.forEach(System.out::println);

        QueueFun<String> dequeue = enqueue.dequeue();

        System.out.println(ANSI_RED);
        dequeue.forEach(System.out::println);

        System.out.println(ANSI_GREEN);
        System.out.println(dequeue.peek());

        System.out.println(ANSI_CYAN);
        System.out.println(dequeue.isEmpty());

        System.out.println(ANSI_PURPLE);
        System.out.println(dequeue.size());
    }
}
