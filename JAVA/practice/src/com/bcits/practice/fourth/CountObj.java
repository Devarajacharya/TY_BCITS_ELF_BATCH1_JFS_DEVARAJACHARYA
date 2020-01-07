package com.bcits.practice.fourth;

public class CountObj {
	
	static int count=0;
	CountObj() {
        count++;
    }
	
    public static void main(String[] args) 
    {
    	CountObj obj1 = new CountObj();
    	CountObj obj2 = new CountObj();
    	CountObj obj3 = new CountObj();
    	CountObj obj4 = new CountObj();
        System.out.println("Number of objects created : "+count);
    }
}

