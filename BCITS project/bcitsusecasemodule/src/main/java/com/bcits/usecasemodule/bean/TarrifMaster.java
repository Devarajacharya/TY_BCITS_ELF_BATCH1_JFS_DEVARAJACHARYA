package com.bcits.usecasemodule.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tarrif_master")
public class TarrifMaster implements Serializable{
	@EmbeddedId
	private TariffMasterPK masterPK;
	@Column
	private double amount;
}
