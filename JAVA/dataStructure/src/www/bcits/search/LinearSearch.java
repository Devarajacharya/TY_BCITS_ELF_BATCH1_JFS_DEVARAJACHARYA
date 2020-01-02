package www.bcits.search;

public class LinearSearch {
	
	public static int search(int [] arr ,int key) {
		for (int i = 1; i <= arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
	public static void printArr(int num) {
		if (num == -1) {
			System.out.println("Element is not found ..!!!" );
		} else {
			 System.out.println("\n"+ "Element is found at index: " + num);  
		}
	}
}
	
