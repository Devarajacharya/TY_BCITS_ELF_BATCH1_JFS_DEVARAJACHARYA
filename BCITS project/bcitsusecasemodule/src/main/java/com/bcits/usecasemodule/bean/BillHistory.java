package com.bcits.usecasemodule.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="bill_history")
public class BillHistory {
	@Id
	private String rrNumber;
	private double amount;
	private Date paymentDate;
	private String status;
}
