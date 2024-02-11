package com.lab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{
	
}
