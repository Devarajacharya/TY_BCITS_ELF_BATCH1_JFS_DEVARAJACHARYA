package www.bcits.search;

import java.util.Scanner;

import www.bcits.algorithem.BubbleSort;
import www.bcits.algorithem.PrintArray;
import www.bcits.algorithem.RandomArrayCreation;

public class Search {
	private static Scanner sd;

	public static void main(String[] args) {
		int [] arr=RandomArrayCreation.arrValue();
		arr = BubbleSort.sort(arr);
		PrintArray.print(arr,"Array Elements  ");
		System.out.println();
		sd = new Scanner(System.in);
		System.out.println("Enter the elements to search : ");
		int key = sd.nextInt();
		DurationCount.countDurationBinarySearch(arr,key);
		DurationCount.countDurationLinearSearch(arr,key);
		
		
	}

}
