package com.bcits.jpawithhibernateapp.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bcits.jpawithhibernate.onetomany.EmployeeEducationPK;

import lombok.Data;
@Data
@Entity
@Table(name="employee_education_info")
public class EmployeeEducationInfo implements Serializable{
	@EmbeddedId
	private EmployeeEducationPK eduPK;
	private String college_name ;
	private Date YOP ;
	private String stream  ;
	private double percentage;
	private String university;
	@MapsId("empid")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empid")
	private EmployeePrimaryInfo primaryInfos;
}
