package www.bcits.algorithem;

public class Sort {
		
	public static void main(String[] args) {
		
		int [] num= RandomArrayCreation.arrValue();
		System.out.println("Before sort : ");
		for(int n1 : num) {
			System.out.print(n1 +"  ");
		}
//		int[] r =RevArray.rev(num);
		int [] res1 = CountDuration.countDurationBubbleSort(num);
		int [] res2 = CountDuration.countDurationSelectionSort(num);
		int [] res3 = CountDuration.countDurationQuickSort(num);
		int [] res4 = CountDuration.countDurationInsertionSort(num);
		int [] res5 = CountDuration.countDurationMergeSort(num);

		PrintArray.print(res1,"After Boubble Sort");
		PrintArray.print(res2,"After Selection Sort");
		PrintArray.print(res3,"After Quick Sort");
		PrintArray.print(res4,"After Insertion Sort");
		PrintArray.print(res5,"After Merge Sort");
		
		
	}
}
