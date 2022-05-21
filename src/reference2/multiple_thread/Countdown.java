package reference2.multiple_thread;

public class Countdown {

//    https://www.guru99.com/java-stack-heap.html
//    Object instance (countdown) and local variable (int i) store in the heap memory,
//    which is share across the thread in the application.
    private int i;

    // Synchronized method helped thread to print all the value without skipping the decrement data inside the loop
    // even the execution of the project share the same instance (countdown) during the execution time.
    public /* synchronized */ void doCountDown(){
        String color;

        switch (Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
                break;
        }
        // synchronized scope execution will skip the decrement data inside the loop
        // because only one color object can hold at the time, so only one thread can execute the for statement.
//        synchronized (color){

        //the result will show as we expected using this parameter
        synchronized (this){
            for(/* int */ i=10; i>0;i--){
                System.out.println(color+Thread.currentThread().getName()+": i = "+i);
            }
        }
    }
}
