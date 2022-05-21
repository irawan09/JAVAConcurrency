package reference1.ParallelComputation.MergeSortAlgorithm;

import java.util.Random;

import static reference1.ParallelComputation.MergeSortAlgorithm.ThreadColor.ANSI_BLUE;

public class App {

    public static void main(String[] args){
        int numOfThreads = Runtime.getRuntime().availableProcessors();

        System.out.println(ANSI_BLUE+"Number of core your computer: "+numOfThreads);
        System.out.println("-----------------------------------------------");

        int n = 10_000_000;
        int[] numbers1 = createRandomArray(n);
        int[] numbers2 = createRandomArray(n);


        /** Computation for sequential mergesort algorithm */
        long startTime1 = System.currentTimeMillis();
        MergeSort mergeSort = new MergeSort(numbers1);
        mergeSort.sort();
        long endTime1 = System.currentTimeMillis();
        System.out.printf("Computation Time with Sequential %6d ms\n", endTime1 - startTime1);
//        mergeSort.showResult();

        /** Computation for parallel mergesort algorithm */
        long startTime2 = System.currentTimeMillis();
        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(numbers2);
        parallelMergeSort.parallelMergeSort(0, numbers2.length-1, numOfThreads);
        long endTime2 = System.currentTimeMillis();
        System.out.printf("Computation Time with Parallel %6d ms\n", endTime2-startTime2);
//        parallelMergeSort.showResult();
    }

    public static int[] createRandomArray(int n){
        Random random = new Random();

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = random.nextInt(n);
        }
        return a;
    }

}
