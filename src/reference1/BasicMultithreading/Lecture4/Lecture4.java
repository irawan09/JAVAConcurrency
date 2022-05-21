package reference1.BasicMultithreading.Lecture4;

public class Lecture4 {

    public static void main(String[] args){

        Runner1 t1 = new Runner1();
        Runner2 t2 = new Runner2();

        t1.start();
        t2.start();

        /*
        * without join() method then the execution of printing
        * "Finished the tasks..." will comes first,
        * then after that the Processor will start execute the thread.
        * if you join(), then the execution of thread 1 and 2
        * will be together.
        * */
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished the tasks...");
    }
}
