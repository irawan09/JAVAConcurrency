package AnotherSources.ParallelComputation.MergeSortAlgorithm;

import java.util.Random;

import static AnotherSources.ParallelComputation.MergeSortAlgorithm.ThreadColor.ANSI_BLUE;

public class App {

    public static Random random = new Random();

    public static void main(String[] args){
        int numOfThreads = Runtime.getRuntime().availableProcessors();

        System.out.println(ANSI_BLUE+"Number of threads/core: "+numOfThreads);
        System.out.println("-----------------------------------------------");

        int[] numbers = createRandomArray();

        /** Print first 10 elements */
//        for(int i=0; i<numbers.length;i++){
//            System.out.println(numbers[i]);
//        }

        MergeSort mergeSort = new MergeSort(numbers);
        long startTime1 = System.currentTimeMillis();
        long endTime1 = System.currentTimeMillis();

        /** Computation for sequential mergesort algorithm */
//        startTime1 = System.currentTimeMillis();
//        mergeSort.mergeSort(0,numbers.length-1);
//        mergeSort.showResult();
//        endTime1 = System.currentTimeMillis();
//        System.out.println("Computation Time: "+(startTime1-endTime1)+" ms");

        /** Please be carefull,  if you run parallel algorithm in your personal computer
         * because this computation requires a lot of resources */

        /** Computation for parallel mergesort algorithm */
        startTime1 = System.currentTimeMillis();
        endTime1 = System.currentTimeMillis();
        System.out.println("Computation Time: "+(startTime1-endTime1)+" ms");
    }

    public static int[] createRandomArray(){
        int[] a = new int[10];
        for(int i=0; i<10; i++){
            a[i] = random.nextInt(10000);
        }
        return a;
    }

}
