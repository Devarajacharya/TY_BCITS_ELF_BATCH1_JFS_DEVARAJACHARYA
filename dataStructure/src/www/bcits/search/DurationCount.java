package www.bcits.search;

import java.time.Duration;
import java.time.Instant;

public class DurationCount {
	
	public static void countDurationBinarySearch (int []arr ,int key) {
		Instant start = Instant.now();
		BinarySearch.search(arr,key);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.err.println("\n"+ "Binary Search took "+seconds+" seconds");
	}
	
	public static void countDurationLinearSearch (int []arr ,int key) {
		Instant start = Instant.now();
		int res = LinearSearch.search(arr,key);
		LinearSearch.printArr(res);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.err.println("\n"+ "Binary Search took "+seconds+" seconds");
	}
}
