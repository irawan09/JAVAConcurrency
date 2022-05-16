package AnotherSources.ParallelComputation.MergeSortAlgorithm;

import java.util.Arrays;

import static AnotherSources.ParallelComputation.MergeSortAlgorithm.ThreadColor.*;

public class ParallelMergeSort {

    public void parallelMergeSort(int[] numbers, int numOfThreads) {
        if(numOfThreads <= 1){
            mergeSort(numbers);
            return;
        }

        int middleIndex = numbers.length/2;

        int[] leftSubArray = Arrays.copyOfRange(numbers,0, middleIndex);
        int[] rightSubArray = Arrays.copyOfRange(numbers,middleIndex, numbers.length);

        Thread leftSorter = mergeSortThread(leftSubArray, numOfThreads);
        Thread rightSorter = mergeSortThread(rightSubArray, numOfThreads);

        leftSorter.start();
        rightSorter.start();

        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge(leftSubArray, rightSubArray, numbers);
    }

    private void merge(int[] leftSubArray, int[] rightSubArray, int[] numbers) {

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<leftSubArray.length && j < rightSubArray.length){
            if (leftSubArray[i] < rightSubArray[j]){
                numbers[k++] = leftSubArray[i++];
            } else {
                numbers[k++] = rightSubArray[j++];
            }
        }

        while (i < leftSubArray.length){
            numbers[k++] = leftSubArray[i++];
        }

        while (j < rightSubArray.length){
            numbers[k++] = rightSubArray[j++];
        }
    }

    private Thread mergeSortThread(int[] numbers, int numOfThreads) {
        return new Thread(){
            @Override
            public void run() {
                parallelMergeSort(numbers, numOfThreads);
            }
        };
    }

    private void mergeSort(int[] numbers) {

        if(numbers.length < 1){
            return;
        }

        int mid = numbers.length/2;

        int[] left = Arrays.copyOfRange(numbers, 0, mid);
        int[] right = Arrays.copyOfRange(numbers, mid, numbers.length);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, numbers);
    }
}
