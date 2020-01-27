package com.bcits.jpawithhibernateapp.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table (name ="project_info")
public class ProjectInfo implements Serializable{
	@Id
	private int prjid ;
	private String prjname ;
	private String technology ;
	private Date start_date ;
	private Date end_date ;
	private String location;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name ="employee_project_info" ,joinColumns = @JoinColumn(name="project_id") 
				,inverseJoinColumns = @JoinColumn(name="emp_id"))
	private List<EmployeePrimaryInfo> primary;
	
}
