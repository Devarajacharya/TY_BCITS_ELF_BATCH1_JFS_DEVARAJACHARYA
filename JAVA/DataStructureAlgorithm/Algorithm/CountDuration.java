package www.bcits.algorithem;

import java.time.Duration;
import java.time.Instant;

public class CountDuration {
	
	public static int[] countDurationBubbleSort (int []num) {
		
		Instant start = Instant.now();
		BubbleSort.sort(num);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.err.println("\n"+ "bubble sort took "+seconds+" seconds");
		return num;
	}
	
	public static int[] countDurationSelectionSort (int []num) {
		
		Instant start = Instant.now();
		SelectionSort.sort(num);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.err.println("\n"+ "selection sort took "+seconds+" seconds");
		return num;
	}
	
	public static int[] countDurationQuickSort (int []arr) {
		
		Instant start = Instant.now();
		QuickSort.sort(arr,0,arr.length-1);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.err.println("\n"+ "Quicksort took "+seconds+" seconds");
		return arr;
	}
	
	public static int[] countDurationInsertionSort (int []arr) {
		
		Instant start = Instant.now();
		InsertionSort.sort(arr);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.err.println("\n"+ "InsertionSort took "+seconds+" seconds");
		return arr;
	}

	public static int[] countDurationMergeSort (int []arr) {
	
	Instant start = Instant.now();
	MergeSort.sort(arr);
	Instant end = Instant.now();
	Long duration =Duration.between(start, end).toMillis();
	double seconds =duration/1000.0;
	System.err.println("\n"+ "MergeSort took "+seconds+" seconds");
	return arr;
}
}
