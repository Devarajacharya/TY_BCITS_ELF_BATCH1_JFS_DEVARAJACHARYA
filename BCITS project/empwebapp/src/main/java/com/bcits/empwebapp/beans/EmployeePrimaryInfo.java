package com.bcits.empwebapp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name ="employee_primary_info")
public class EmployeePrimaryInfo implements Serializable {
		@Id
		@Column(name="emp_id")
		private int empId;
		@Column
		private String empname;
		@Column(name="mobile_no")
		private long mobileNum;
		@Column
		private Date DOB;
		@Column
		private Date DOJ;
		@Column
		private String designation ;
		@Column(name ="blood_group")
		private String bloodGroup;
		@Column(name="dept_id")
		private int deptId;
		@Column(name="manager_id")
		private int managerId;
		@Column
		private double sal;
		@Column(name ="oficial_mail")
		private String officialMail;
		@Column
		private String password;

}
