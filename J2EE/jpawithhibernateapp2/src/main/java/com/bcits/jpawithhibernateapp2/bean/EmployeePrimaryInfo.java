package com.bcits.jpawithhibernateapp2.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernate.manytomany.ProjectInfo;
import com.bcits.jpawithhibernate.maytoone.EmployeeAddressInfo;
import com.bcits.jpawithhibernate.onetoone.EmployeeBankInfo;
import com.bcits.jpawithhibernate.onetoone.EmployeeSecondaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeePrimaryInfo implements Serializable{
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
	private String designation ;
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
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primary") //bidirectional
	private EmployeeSecondaryInfo secondary_info;
	private EmployeeBankInfo bank_info;

	@Exclude
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "primaryInfo")
	private List<EmployeeAddressInfo> addressinfo;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy = "primary")
	private List<ProjectInfo> project;
	
	/*
	 * public EmployeeSecondaryInfo getSecondary_info() { return secondary_info; }
	 * public void setSecondary_info(EmployeeSecondaryInfo secondary_info) {
	 * this.secondary_info = secondary_info; } public int getEmpid() { return empid;
	 * } public void setEmpid(int empid) { this.empid = empid; } public String
	 * getEmpname() { return empname; } public void setEmpname(String empname) {
	 * this.empname = empname; } public long getMobile_no() { return mobile_no; }
	 * public void setMobile_no(long mobile_no) { this.mobile_no = mobile_no; }
	 * public Date getDOB() { return DOB; } public void setDOB(Date dOB) { DOB =
	 * dOB; } public Date getDOJ() { return DOJ; } public void setDOJ(Date dOJ) {
	 * DOJ = dOJ; } public String getDesignation() { return designation; } public
	 * void setDesignation(String designation) { this.designation = designation; }
	 * public String getBlood_group() { return blood_group; } public void
	 * setBlood_group(String blood_group) { this.blood_group = blood_group; } public
	 * int getDeptid() { return deptid; } public void setDeptid(int deptid) {
	 * this.deptid = deptid; } public int getManager_id() { return manager_id; }
	 * public void setManager_id(int manager_id) { this.manager_id = manager_id; }
	 * public double getSal() { return sal; } public void setSal(double sal) {
	 * this.sal = sal; } public String getOfficial_mail() { return official_mail; }
	 * public void setOfficial_mail(String official_mail) { this.official_mail =
	 * official_mail; }
	 */
	
	

}
