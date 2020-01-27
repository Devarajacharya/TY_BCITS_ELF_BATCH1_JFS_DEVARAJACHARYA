package com.bcits.hibernate.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_secondary_info")
public class EmployeeSecondaryInfo implements Serializable {
	@Id
	private int empid;
	@Column(name = "personal_mail")
	private String personalMail;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private String nationality;
	@Column
	private String job_loc;
	@Column
	private String is_married;
	@Column
	private String govt_id;
	@Column
	private String gurdian_name;
	@Column
	private long gurdian_contactno;
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empid")
	private EmployeePrimaryInfo primary;

}
