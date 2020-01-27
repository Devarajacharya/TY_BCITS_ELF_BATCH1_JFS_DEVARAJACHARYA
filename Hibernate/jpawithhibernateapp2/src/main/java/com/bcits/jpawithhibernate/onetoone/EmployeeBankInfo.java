package com.bcits.jpawithhibernate.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "employee_bank_info")
public class EmployeeBankInfo implements Serializable {
	@Id
	private int empid;
	private long account_no;
	private String bank_name;
	private String branch_name;
	private String IFSC_code;

	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empid")
	private EmployeePrimaryInfo primary;
	
	/*
	 * public int getEmpid() { return empid; } public void setEmpid(int empid) {
	 * this.empid = empid; } public long getAccount_no() { return account_no; }
	 * public void setAccount_no(long l) { this.account_no = l; } public String
	 * getBank_name() { return bank_name; } public void setBank_name(String
	 * bank_name) { this.bank_name = bank_name; } public String getBranch_name() {
	 * return branch_name; } public void setBranch_name(String branch_name) {
	 * this.branch_name = branch_name; } public String getIFSC_code() { return
	 * IFSC_code; } public void setIFSC_code(String iFSC_code) { IFSC_code =
	 * iFSC_code; } public EmployeePrimaryInfo getPrimary() { return primary; }
	 * public void setPrimary(EmployeePrimaryInfo primary) { this.primary = primary;
	 * }
	 */

}
