package com.bcits.springrestjaxb.beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@XmlRootElement(name = "user-info")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({ "employeeId", "empname" })
@JsonRootName("userInfo")
public class UserInfoBean {

//		@XmlAttribute(name="emp-Id")
	@XmlElement(name = "user-Id")
	@JsonProperty("employeeId")
	private Integer empid;
	@XmlElement(name = "user-Name")
	private String empname;
	@XmlElement(name = "mobile-Number")
	private Long mobileNo;
	private Date DOB;
	private Date DOJ;
	private String designation;
	@XmlElement(name = "blood-Group")
	private String bloodGroup;
	@XmlElement(name = "dept-Id")
	private Integer deptId;
	@XmlElement(name = "manager-Id")
	private Integer managerId;
	@XmlElement(name = "official-Id")
	private String officialMail;
	private Double sal;
//		@XmlTransient                  //to avoid binding of field to XML.
	private String password;
	@XmlElement(name = "user-other-info")
	private UserOtherInfobean useOtherInfobean;
	@JsonProperty("address")
	@XmlElementWrapper(name = "adress-type")
	private List<UserAddressBean> userAddressBean;

}// End Of class
