package AnotherSources.ParallelComputation.ParallelSum;

import static AnotherSources.ParallelComputation.ParallelSum.ThreadColor.*;
import java.util.Random;

public class App {

    public static void main(String[] args){

        Random random = new Random();
        SequentialSum sequentialSum = new SequentialSum();

        int numOfProcessors = Runtime.getRuntime().availableProcessors();

        int[] nums = new int[1_000_000_000];

        for(int i=0; i<nums.length; i++){
            nums[i] = random.nextInt(101) +1; // 1..100
        }

        long start = System.currentTimeMillis();

        System.out.println(ANSI_BLUE+"Sum is: "+sequentialSum.sum(nums));
        System.out.println(ANSI_RED+"Single: "+(System.currentTimeMillis()-start)+"ms");

        start = System.currentTimeMillis();

        ParallelSum parallelSum = new ParallelSum(numOfProcessors);

        System.out.println(ANSI_BLUE+"Sums is: "+parallelSum.parallelSum(nums));
        System.out.println(ANSI_GREEN+"Parallel: "+(System.currentTimeMillis()-start)+"ms");
    }
}
