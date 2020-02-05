package com.bcits.usecasemodule.bean;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "query")
public class SupportBean implements Serializable{
	@EmbeddedId
	private SupportBeanPK supportBeanPK; 
	private String support;
	private String request;
	private String region;
}
