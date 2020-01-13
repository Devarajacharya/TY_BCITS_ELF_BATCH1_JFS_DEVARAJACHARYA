package com.bcits.jpawithhibernateapp2.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "Product_info")
public class Product implements Serializable{
	@Id
	private int pid;
	private String pname;
	/*
	 * public int getPid() { return pid; } 
	 * public void setPid(int pid) { this.pid = pid; }
	 * public String getPname() { return pname; }
	 * public void setPname(String pname) { this.pname = pname; }
	 */
	
}
