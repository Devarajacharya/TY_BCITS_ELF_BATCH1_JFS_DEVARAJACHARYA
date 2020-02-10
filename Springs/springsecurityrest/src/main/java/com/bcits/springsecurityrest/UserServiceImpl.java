package com.bcits.springsecurityrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bcits.springsecurityrest.DAO.EmpDAO;

@Component
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private EmpDAO dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		userDetailsImpl.setEmpInfo(dao.getEmployee(Integer.parseInt(username)));
		return userDetailsImpl;
	}

}
