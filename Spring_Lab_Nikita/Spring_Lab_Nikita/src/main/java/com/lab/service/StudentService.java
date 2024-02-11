package com.lab.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.lab.entity.Student;

public interface StudentService {
	@PreAuthorize("hasRole('ADMIN')")
	public Student addData(Student data);
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<Student> getData();
	
    @PreAuthorize("hasRole('ADMIN')")
	public Student editData(Student e);
    
   @PreAuthorize("hasRole('ADMIN')")
	public String deleteData(long id);
	
   UserDetailsService getUserDetailsService();
}
