package com.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lab.entity.Student;
import com.lab.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService serv;
	
	@GetMapping("/students")
	@Operation(summary = "To get all the student data")
	public ResponseEntity<?> get() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(serv.getData(), HttpStatus.OK);
		} 
		catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	@PostMapping("/")
	@Operation(summary = "put the new student details")
	public ResponseEntity<?> save(@RequestBody Student student) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(serv.addData(student), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return response;
	}
	
	@PutMapping("/edit")
	@Operation(summary = "to update")
	public ResponseEntity<?> edit(@RequestBody Student student) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(serv.editData(student), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@DeleteMapping("/mobileDelete/{id}")
	@Operation(summary = "delete the record")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(serv.deleteData(id), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
}
