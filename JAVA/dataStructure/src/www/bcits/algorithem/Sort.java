package www.bcits.algorithem;

public class Sort {
		
	public static void main(String[] args) {
		
		int [] num= RandomArrayCreation.arrValue();
		PrintArray.print(num,"Before Sort");
		/*
		 * int[] r =RevArray.rev(num);
		 */		
		int [] res1 = CountDuration.countDurationBubbleSort(num);
		PrintArray.print(res1,"After Boubble Sort");
		
		int [] res2 = CountDuration.countDurationSelectionSort(num);
		PrintArray.print(res2,"After Selection Sort");
		
		int [] res3 = CountDuration.countDurationQuickSort(num);
		PrintArray.print(res3,"After Quick Sort");
		
		int [] res4 = CountDuration.countDurationInsertionSort(num);
		PrintArray.print(res4,"After Insertion Sort");
		
		int [] res5 = CountDuration.countDurationMergeSort(num);
		PrintArray.print(res5,"After Merge Sort");
		
		
		
	
		
		
		
	}
}
