package com.bcits.usecasemodule.bean;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="bill_history")
public class BillHistory implements Serializable{
	@EmbeddedId
	private BIllHistoryPK biHistoryPK;
	private double amount;
	private String status;
}
