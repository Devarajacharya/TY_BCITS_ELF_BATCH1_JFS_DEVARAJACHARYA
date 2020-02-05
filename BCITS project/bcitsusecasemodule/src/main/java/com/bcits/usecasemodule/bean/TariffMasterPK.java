package com.bcits.usecasemodule.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class TariffMasterPK implements Serializable {
	@Column
	private String type;
	@Column
	private long range;
}
