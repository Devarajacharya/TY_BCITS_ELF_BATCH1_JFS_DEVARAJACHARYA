package com.bcits.jpawithhibernateapp.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	
}
