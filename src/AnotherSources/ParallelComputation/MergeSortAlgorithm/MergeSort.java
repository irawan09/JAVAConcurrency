package AnotherSources.ParallelComputation.MergeSortAlgorithm;

import org.jetbrains.annotations.Contract;

import static AnotherSources.ParallelComputation.MergeSortAlgorithm.ThreadColor.*;

public class MergeSort {

    private final int[] nums;
    private final int[] tempArray;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

//    public void parallelMergeSort(int low, int high, int numOfThread){
//
//        if (numOfThread <= 1){
//            mergeSort(low, high);
//            return;
//        }
//
//        int middleIndex = (low + high)/2;
//
//        Thread leftSorter = mergeSortThread(low, middleIndex, numOfThread);
//        Thread rightSorter = mergeSortThread(middleIndex+1, high, numOfThread);
//
//        leftSorter.start();
//        rightSorter.start();
//
//        try {
//            leftSorter.join();
//            rightSorter.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        merge(low, middleIndex, high);
//    }

    private void merge(int low, int middleIndex, int high) {
        for(int i=0; i<=high; i++){
            tempArray[i] = nums[i];
        }
        int i = low;
        int j = middleIndex +1;
        int k = low;

        while((i<=middleIndex) && (j <= high)){
            if(tempArray[i] <= tempArray[j]){
                nums[k] = tempArray[i];
                i++;
            } else {
                nums[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while(i <= middleIndex){
            nums[k] = tempArray[i];
            k++;
            i++;
        }

        while(j <= high){
            nums[k] = tempArray[j];
            k++;
            j++;
        }
    }

//    @Contract("_, _, _ -> new")
//    private Thread mergeSortThread(int low, int high, int numOfThread) {
//        return new Thread(){
//            @Override
//            public void run() {
//                parallelMergeSort(low, high, numOfThread/2);
//            }
//        };
//    }

    public void mergeSort(int low, int high) {
        if(low >= high){
            return;
        }

        int middle = (low+high)/2;

        mergeSort(low,middle);
        mergeSort(middle+1, high);
        merge(low, middle, high);
    }

    public void showResult(){
        for(int i=0; i< nums.length; i++){
            System.out.println(ANSI_BLUE+nums[i]+" ");
        }
    }
}
