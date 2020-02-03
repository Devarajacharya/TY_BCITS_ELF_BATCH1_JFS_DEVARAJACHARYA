package com.bcits.usecasemodule.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="monthly_consumption")
public class MonthlyConsumption implements Serializable{
	@EmbeddedId
	private MonthlyConsumptionPK consumptionPk;
	@Column(name="unit_consumed")
	private long unitConsumed;
	@Column(name="bill_amount")
	private double billAmount; 
	@Column
	private String region;
	
}
