package com.bcits.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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
	

}
