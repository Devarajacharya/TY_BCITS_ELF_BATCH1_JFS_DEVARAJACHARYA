package www.bcits.algorithem;

public class MergeSort {
	public static int[] merge(int arr[], int beg, int mid, int end)  
	{  
	  
	int l = mid - beg + 1;  
	int r = end - mid;  
	  
	int LeftArray[]  = new int [l];  
	int RightArray[] = new int [r];  
	  
	for (int i=0; i<l; ++i)  
	LeftArray[i] = arr[beg + i];  
	  
	for (int j=0; j<r; ++j)  
	RightArray[j] = arr[mid + 1+ j];  
	  
	  
	int i = 0, j = 0;  
	int k = beg;  
	while (i < l && j < r)  {  
	if (LeftArray[i] <= RightArray[j])  
	{  
	arr[k] = LeftArray[i];  
	i++;  
	} else {  
	arr[k] = RightArray[j];  
	j++;  
	}  
	k++;  
	}  
	while (i<l)  
	{  
	arr[k] = LeftArray[i];  
	i++;  
	k++;  
	}  
	  
	while (j<r)  
	{  
	arr[k] = RightArray[j];  
	j++;  
	k++;  
	} 
	return arr;
	}  
	  
	public static  int[]  sort(int a[],int f,int l)  
	{  
	
	if (f<l) {  
	int mid = (f+l)/2;  
	sort(a, f, mid);  
	sort(a , mid+1, l);  
	merge(a, f, mid, l);  
	}
	return a;
	}
}