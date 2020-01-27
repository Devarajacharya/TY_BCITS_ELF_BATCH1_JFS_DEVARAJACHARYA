package com.bcits.jpawithhibernate.onetomany;

import java.io.Serializable;

import javax.persistence.Embeddable;
import lombok.Data;
@Data
@Embeddable
public class EmployeeEducationPK implements Serializable{
	private int empid ;
	private String education_type;
}
