package com.bcits.springrest.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeeInfoBean {
	@Id
	@Column(name="emp_id")
	private Integer empid;
	@Column
	private String empname;
	@Column(name="mobile_no")
	private Long mobileNo;
	@Column
//	@DateTimeFormat(iso = ISO.DATE)
	private Date DOB;
	@Column
//	@DateTimeFormat(iso = ISO.DATE)
	private Date DOJ;
	@Column
	private String designation ;
	@Column(name="blood_group")
	private String bloodGroup;
	@Column(name="dept_id")
	private Integer deptId;
	@Column(name="manager_id")
	private Integer managerId;
	@Column(name="official_mail")
	private String officialMail;
	@Column
	private Double sal;
	@Column
	private String password;
}
