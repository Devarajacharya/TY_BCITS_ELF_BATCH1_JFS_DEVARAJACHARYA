package com.bcits.String;

import java.time.Duration;
import java.time.Instant;

public class CountDuration {
	
	public static boolean CountDurationPalindrome1(String str) {
		Instant start = Instant.now();
		boolean res = Question1.palindrome1(str);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.err.println("Palindrome1 took "+seconds+" seconds");
		return res;	
	}
	
	public static boolean CountDurationPalindrome2(String str) {
		Instant start = Instant.now();
		boolean res = Question1.palindrome1(str);
		Instant end = Instant.now();
		Long duration =Duration.between(start, end).toMillis();
		double seconds =duration/1000.0;
		System.err.println("Palindrome2 took "+seconds+" seconds");
		return res;
		
	}
}
