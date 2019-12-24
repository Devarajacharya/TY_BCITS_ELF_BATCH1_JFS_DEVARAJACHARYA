package www.bcits.algorithem;

public class InsertionSort {
	
	public static void sort(int []a) {
		for(int i=0 ;i<a.length;i++) {
			int key=a[i];
			int j=i-1;
			while(j>-1&&a[j]>key) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=key;
		}
	}

}
