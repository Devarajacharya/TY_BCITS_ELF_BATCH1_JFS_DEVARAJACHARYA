package com.bcits.usecasemodule.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class BIllHistoryPK implements Serializable {
	private String rrNumber;
	@Column(name="payment_date")
	private Date paymentDate;
}
