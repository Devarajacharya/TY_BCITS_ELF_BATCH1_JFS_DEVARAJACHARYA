package com.bcits.jpawithhibernate.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernateapp2.bean.EmployeePrimaryInfo;

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

	public String getPersonalMail() {
		return personalMail;
	}

	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	public EmployeePrimaryInfo getPrimary() {
		return primary;
	}

	public void setPrimary(EmployeePrimaryInfo primary) {
		this.primary = primary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getPersonalmail() {
		return personalMail;
	}

	public void setPersonal_mail(String personalMail) {
		this.personalMail = personalMail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getJob_loc() {
		return job_loc;
	}

	public void setJob_loc(String job_loc) {
		this.job_loc = job_loc;
	}

	public String getIs_married() {
		return is_married;
	}

	public void setIs_married(String is_married) {
		this.is_married = is_married;
	}

	public String getGovt_id() {
		return govt_id;
	}

	public void setGovt_id(String govt_id) {
		this.govt_id = govt_id;
	}

	public String getGurdian_name() {
		return gurdian_name;
	}

	public void setGurdian_name(String gurdian_name) {
		this.gurdian_name = gurdian_name;
	}

	public long getGurdian_contactno() {
		return gurdian_contactno;
	}

	public void setGurdian_contactno(long gurdian_contactno) {
		this.gurdian_contactno = gurdian_contactno;
	}

}
