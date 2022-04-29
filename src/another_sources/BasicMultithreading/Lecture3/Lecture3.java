package another_sources.BasicMultithreading.Lecture3;

public class Lecture3 {

    public static void main(String[] args){

        Runner1 t1 = new Runner1();
        Runner2 t2 = new Runner2();

        t1.start();
        t2.start();
    }
}
