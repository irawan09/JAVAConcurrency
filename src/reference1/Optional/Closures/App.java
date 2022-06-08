package reference1.Optional.Closures;

public class App {

    public static void main(String[] args){

        final int[] val = {111};

        Task lambda = () -> {

            val[0] = 112;
            System.out.println(val[0]);
            System.out.println("Task completed");
        };

        printValue(lambda);
    }

    private static void printValue(Task lambda) {

        lambda.doTask();
    }
}
