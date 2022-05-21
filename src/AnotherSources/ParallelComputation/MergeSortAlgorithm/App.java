package AnotherSources.ParallelComputation.MergeSortAlgorithm;

import java.util.Random;

import static AnotherSources.ParallelComputation.MergeSortAlgorithm.ThreadColor.ANSI_BLUE;

public class App {

    public static void main(String[] args){
        int numOfThreads = Runtime.getRuntime().availableProcessors();

        System.out.println(ANSI_BLUE+"Number of core your computer: "+numOfThreads);
        System.out.println("-----------------------------------------------");

        int[] numbers1 = createRandomArray(5);
        int[] numbers2 =  new int[numbers1.length];

        /** Copy the array number1 into array number2 */
        for(int i=0; i<numbers1.length;i++){
            numbers2[i] = numbers1[1];
        }

        MergeSort mergeSort = new MergeSort(numbers1);
        long startTime1;
        long endTime1;

        /** Computation for sequential mergesort algorithm */
        startTime1 = System.currentTimeMillis();
        mergeSort.mergeSort(0,numbers1.length-1);
        endTime1 = System.currentTimeMillis();
        System.out.println("Computation Time: "+(startTime1-endTime1)+" ms");
        mergeSort.showResult();

        /** Please be carefull,  if you run parallel algorithm in your personal computer
         * because this computation requires a lot of resources */

        /** Computation for parallel mergesort algorithm */
        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(numbers2);
        startTime1 = System.currentTimeMillis();
        parallelMergeSort.parallelMergeSort(numbers2, numOfThreads);
        endTime1 = System.currentTimeMillis();
        System.out.println("Computation Time: "+(startTime1-endTime1)+" ms");
        parallelMergeSort.showResult();
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
