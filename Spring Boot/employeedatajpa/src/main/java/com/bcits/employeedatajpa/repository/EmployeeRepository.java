package com.bcits.employeedatajpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bcits.employeedatajpa.bean.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer>{

	@Query("from EmployeeInfoBean where empid= :id and password= :psw")
	public EmployeeInfoBean findByIdAndPassword(int id ,String psw);
}
