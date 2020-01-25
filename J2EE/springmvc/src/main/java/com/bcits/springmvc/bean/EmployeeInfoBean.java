package com.bcits.springmvc.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeeInfoBean {
	@Id
	@Column(name="emp_id")
	private int empid;
	@Column
	private String empname;
	@Column(name="mobile_no")
	private long mobileNo;
	@Column
	private Date DOB;
	@Column
	private Date DOJ;
	@Column
	private String designation ;
	@Column(name="blood_group")
	private String bloodGroup;
	@Column(name="dept_id")
	private int deptId;
	@Column(name="manager_id")
	private int managerId;
	@Column
	private double sal;
	@Column
	private String password;
}
