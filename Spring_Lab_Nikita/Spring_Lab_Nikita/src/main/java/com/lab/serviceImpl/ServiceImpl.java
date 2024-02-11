package com.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.lab.entity.Student;
import com.lab.repository.StudentRepository;
import com.lab.service.StudentService;

@Service
public class ServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repo;
	
	
	 @Autowired
	 private UserDetailsService userDetailsService;
	
	@Override
	public Student addData(Student data) {
		return repo.save(data);
	}

	@Override
	public List<Student> getData() {
		return repo.findAll();
	}

	@Override
	public Student editData(Student e) {
		if(repo.equals(e.getStudentId())){
			repo.save(e);
		}
		return e;
	}

	@Override
	public String deleteData(long id) {
		String status;
		if (repo.existsById(id)) {
			repo.deleteById(id);
			status = "deleted sucessfully";
		} 
		else {
			status = "delete is not sucessful";
		}

		return status;
	}

	
	 @Override
	    public UserDetailsService getUserDetailsService() {
	        return userDetailsService;
	    }
}
