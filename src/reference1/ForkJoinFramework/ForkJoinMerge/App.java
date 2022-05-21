package reference1.ForkJoinFramework.ForkJoinMerge;

import static reference1.ForkJoinFramework.ForkJoinMerge.ThreadColor.*;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {

		int[] nums = initializeNums();
		SequentialMergesort mergesort = new SequentialMergesort(nums);

		long start = System.currentTimeMillis();
		mergesort.mergeSort(nums);
		System.out.println(ANSI_BLUE+"Time taken with sequential sort: " + (System.currentTimeMillis() - start) + " ms");
		
		MergeSortTask rootTask = new MergeSortTask(nums);
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		start = System.currentTimeMillis();
		pool.invoke(rootTask);
		System.out.println(ANSI_RED+"Time taken with parallel sort: " + (System.currentTimeMillis() - start) + " ms");
		
		
	}

	private static int[] initializeNums() {

		Random random = new Random();
		int[] nums = new int[100_000_000];

		for (int i = 0; i < 100_000_000; ++i)
			nums[i] = random.nextInt(100);

		return nums;
	}
}
