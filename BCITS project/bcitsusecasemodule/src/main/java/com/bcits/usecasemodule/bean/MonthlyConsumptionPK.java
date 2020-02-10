package com.bcits.usecasemodule.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class MonthlyConsumptionPK implements Serializable {
	private String rrNumber;
	private Date date;
}
