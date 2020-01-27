package com.bcits.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name ="department_info")
public class DepartmentInfo implements Serializable{
	@Id
	private int deptid ;
	private String dept_name ;
	private String manager_id ;
	
}
