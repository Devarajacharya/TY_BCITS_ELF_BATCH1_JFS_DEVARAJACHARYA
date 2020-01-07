package com.bcits.practice.first;

import java.io.Serializable;

public class Student implements Serializable {

		private int    id; 
		private String name;
		private double mark;
		
		public Student() {
			super();
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public double getMark() {
			return mark;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setMark(double Mark) {
			this.mark = Mark;
		}

		@Override
		public String toString() {
			return "Student [Id=" + id + ", Name=" + name + ", Mark=" + mark + "]";
		}
			
	}


