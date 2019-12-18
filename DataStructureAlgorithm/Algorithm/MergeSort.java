package www.bcits.algorithem;

public class MergeSort {
	
	public static int [] sort (int[] arr) {
		if(arr.length <= 1) {
			return arr;
		}
		
		int midpoint = arr.length/2;
		int[] left =new int [midpoint];
		int [] right;
		
		if(arr.length % 2 == 0) {
			right =new int[midpoint];
		} else {
			right=new int [midpoint+1];
		}
		
		for (int i = 0; i < midpoint; i++) {
			left[i] =arr[i];
		}
		
		for (int j = 0; j < right.length; j++) {
			right[j] = arr[midpoint+j];
		}
		
		int[] result = new int [arr.length];
		left = sort(left);
		right = sort(right);
		
		result = 
	}
	
	public static int[] merge(int[] left ,int[] right ) {
		int [] 
		
	}
}  
