package www.bcits.algorithem;

public class QuickSort {
	
	public static int [] sort(int [] a,int l,int h) {
		int pivot = a[(l+h)/2];
		int i=l;
		int j=h;
		while(i<=j) {
			while(a[i]<pivot) {
				i++;
			}
			while(a[j]>pivot) {
				j--;
			}
			if(i<=j) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
			if(l<j)
				sort(a,l,j);
			if(i<h)
				sort(a,i,h);
		}
		return a;
	}
	
}
