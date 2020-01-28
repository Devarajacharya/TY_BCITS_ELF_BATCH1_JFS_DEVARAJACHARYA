package com.bcits.springrestjaxb.beans;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@XmlRootElement(name="user-address")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("userAddressInfo")
public class UserAddressBean {
	@XmlElement(name="house-number")
	private int houseNum;
	private String street;
	private String city;
	@XmlElement(name="address-type")
	private String addressType;
}
