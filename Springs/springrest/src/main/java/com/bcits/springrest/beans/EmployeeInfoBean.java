package com.bcits.springrest.beans;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName("EmployeeInfo")
@JsonPropertyOrder({"empid","empname"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeeInfoBean {
	@JsonProperty("EmployeeId")
	@Id
	@Column(name="emp_id")
	private int empid;
	@Column
	private String empname;
	@Column(name="mobile_no")
	private Long mobileNo;
	@Column
	private Date DOB;
	@Column
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
//	@JsonIgnore
	private String password;
}
