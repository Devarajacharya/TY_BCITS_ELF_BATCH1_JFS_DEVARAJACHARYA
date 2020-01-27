package com.bcits.hibernate.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bcits.jpawithhibernate.mapping.EmployeeAddressPK;

import lombok.Data;
@Data
@Entity
@Table(name = "employee_address_info")
public class EmployeeAddressInfo implements Serializable {
	@EmbeddedId
	private EmployeeAddressPK adresspk;
	private int house_no;
	private String address1;
	private String address2;
	private String landmark;
	private String city;
	private long pincode;
	
	@MapsId("empid")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empid")
	private EmployeePrimaryInfo primaryInfo;
	

}
