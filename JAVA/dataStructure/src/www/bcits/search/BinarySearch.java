package www.bcits.search;

public class BinarySearch {
	
	public static void  search(int [] arr ,int key) {
		int last =arr.length-1;
		int first =0;
		 int mid = (first + last)/2;  
		   while( first <= last ){  
		      if ( arr[mid] < key ){  
		        first = mid + 1;     
		      }else if ( arr[mid] == key ){  
				 System.out.println("\n"+ "Element is found at index: " + mid);  
				 break;
		      } else {  
		         last = mid - 1;  
		      }  
		      mid = (first + last)/2;  
		   }  
		   if ( first > last ){  
			   System.out.println("Element is not found ..!!!" );
		   } 	
	}

}
