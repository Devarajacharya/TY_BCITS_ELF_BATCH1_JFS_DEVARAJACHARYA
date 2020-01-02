package www.bcits.algorithem;

public class BubbleSort {
	
public static int [] sort(int [] num) {
		
		int temp=0;
		for (int i = 0; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i] > num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			} 
		}
		return num;	
	}
}
