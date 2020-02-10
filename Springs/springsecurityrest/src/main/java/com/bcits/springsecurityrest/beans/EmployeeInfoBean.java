package com.bcits.springsecurityrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "enp_info")
public class EmployeeInfoBean implements Serializable{
	@Id
	@Column(name = "emp_id")
	private int empId;
	private String password;
	private String role;
	private String name;
	
}//End Of Bean
