package com.bcits.jpawithhibernate.mapping;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmployeeAddressPK implements Serializable{
	private int empid;
	private String address_type;

}
