package www.bcits.algorithem;

import java.time.Duration;
import java.time.Instant;

public class AlgorithmsAnalysis {
	public static Long addUpto(Long num) {
		Long total=0L;
		for (int i = 0; i <= num; i++) {
			total+=i;
		}
		return total;
		
	}
	
	public static Long addUptoQuick(Long num) {
		return num * (num + 1) /2;
	}

	public static void countDurationAddUptoQuick () {
		Long num=9999999999L;
		Instant start = Instant.now();
		System.out.println(addUptoQuick(num));
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.out.println("addUptoQuick took "+seconds+" seconds");
	}
	
	public static void countDurationAddUpto () {
		Long num=9999999999L;
		Instant start = Instant.now();
		System.out.println(addUpto(num));
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.out.println("addUpto took "+seconds+" seconds");
	}
	
	public static void main(String[] args) {
		countDurationAddUptoQuick ();
		countDurationAddUpto ();
	}
}
