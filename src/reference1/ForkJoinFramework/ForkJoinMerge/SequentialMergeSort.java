package reference1.ForkJoinFramework.ForkJoinMerge;

public class SequentialMergeSort {

    private int[] nums;


    public SequentialMergeSort(int[] nums) {
        this.nums = nums;
    }
    public void mergeSort(int[] nums){

        if(nums.length <= 1){
            return;
        }

        int middleIndex = nums.length/2;

    }
}
