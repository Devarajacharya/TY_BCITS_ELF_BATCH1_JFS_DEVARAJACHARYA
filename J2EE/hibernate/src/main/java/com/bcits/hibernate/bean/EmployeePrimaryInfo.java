package com.bcits.hibernate.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "employee_primary_info")
public class EmployeePrimaryInfo implements Serializable {
	@Id
	private int empid;
	@Column
	private String empname;
	@Column
	private long mobile_no;
	@Column
	private Date DOB;
	@Column
	private Date DOJ;
	@Column
	private String designation;
	@Column
	private String blood_group;
	@Column
	private int deptid;
	@Column
	private int manager_id;
	@Column
	private double sal;
	@Column
	private String official_mail;
	@Exclude
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primary")
	private EmployeeSecondaryInfo second_info;

	@Exclude
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "primaryInfo")
	private List<EmployeeAddressInfo> addressinfo;
}
