package com.bcits.usecasemodule.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class AdminInfo {
	@Id
	private String username;
	private String name;
	private String password;	
}
