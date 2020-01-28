package com.bcits.springrestjaxb.beans;

import java.util.Date;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

@Data
@XmlRootElement(name= "emploee-info")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"employeeId","empname","dob"})
@JsonRootName("employeeInfo")
public class EmployeeBean {
	
//	@XmlAttribute(name="emp-Id")
	@JsonProperty("employeeId")
	@XmlElement(name="emp-Id")
	private Integer empid;
	@XmlElement(name="emp-Name")
	private String empname;
	@XmlElement(name="mobile-Number")
	private Long mobileNo;
	private Date DOB;
	private Date DOJ;
	private String designation;
	@XmlElement(name="blood-Group")
	private String bloodGroup;
	@XmlElement(name="dept-Id")
	private Integer deptId;
	@JsonProperty("ManagerId")
	@XmlElement(name="manager-Id")
	private Integer managerId;
	@XmlElement(name="official-Id")
	private String officialMail;
	private Double sal;
//	@XmlTransient    //to avoid binding of field to XML.
	@JsonIgnore
	private String password;
	
}//End Of class
                                                                                                                                                        