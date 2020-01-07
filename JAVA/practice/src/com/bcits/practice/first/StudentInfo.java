package com.bcits.practice.first;

public class StudentInfo {
	
	public static void main(String[] args) {
		
		Student s1=new Student ();
		s1.setId(1);
		s1.setName("virat");
		s1.setMark(76.82);
		
		Student s2=new Student ();
		s2.setId(2);
		s2.setName("rohith");
		s2.setMark(62.82);
		
		Student s3=new Student ();
		s3.setId(3);
		s3.setName("jaddu");
		s3.setMark(54.94);
		
		Student s4=new Student ();
		s4.setId(4);
		s4.setName("pandy");
		s4.setMark(48.06);	
		
		Object [] arry= {s1,s2,s3,s4};
				for (Object obj : arry) {
			System.out.println(obj);
		}
	}

}
