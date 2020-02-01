package com.bcits.usecasemodule.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "consumer_info")
public class ConsumerInfoBean implements Serializable {
	@Id
	@Column(name = "rr_number")
	private String rrNumber;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	@Column(name = "phone_number")
	private long phoneNumber;
	@Column(name = "type_of_consumer")
	private String typeOfConsumer;
	private String region;
	private String password;
	@Column(name="house_number")
	private String houseNumber;
	private String address1;
	private String address2;
	private Date signupDate;
}
