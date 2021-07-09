package com.example.springDataJPAUsingGradle.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springDataJPAUsingGradle.entity.StudentEntity;
import com.example.springDataJPAUsingGradle.exception.RecordNotFoundException;
import com.example.springDataJPAUsingGradle.service.StudentService;


import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "/api", tags = "Student information controller")
@RestController
@RequestMapping("/api")
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired(required = true)
	//This is used to automatically inject implementation class to the studentService object.
	private StudentService studentService;
	
	@ApiOperation(value = "Home page", response = String.class)
	@GetMapping("/home")
	public String home() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		return "Welcome to home page";
	}
	
	//Get the student data
	@ApiOperation(value = "Get all active students", response = Iterable.class)
	@GetMapping("/")
	public List<StudentEntity> students(){
		return studentService.getStudents();
	}
	
	@GetMapping("/{studentId}")
	@ApiOperation(value = "Get student by Id", response = StudentEntity.class)
	public ResponseEntity<StudentEntity> getStudent(@PathVariable String studentId) throws RecordNotFoundException {
		StudentEntity s = studentService.getStudent(Long.parseLong(studentId));
		System.out.println(s);
		if(s == null) {
	         throw new RecordNotFoundException("Invalid employee id : " + studentId);
	    }
	    return new ResponseEntity<StudentEntity>(s, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "Get all active/inactive students", response = Iterable.class)
	public List<StudentEntity> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Add a student", response = StudentEntity.class)
	public ResponseEntity<String> addStudent(@Valid @RequestBody StudentEntity s) {
		studentService.addStudent(s);
		return ResponseEntity.ok("Student is valid");
	}
	
	@PutMapping("/{studentId}")
	@ApiOperation(value = "Update student", response = StudentEntity.class)
	public StudentEntity updateStudent(@PathVariable String studentId, @RequestBody StudentEntity s) {
		return studentService.updateStudent(Long.parseLong(studentId), s);
	}
	
	@DeleteMapping("/{studentId}")
	@ApiOperation(value = "delete student by Id", response = StudentEntity.class)
	public StudentEntity deleteStudent(@PathVariable String studentId) {
		return studentService.deleteStudent(Long.parseLong(studentId));
	}
	
	
	
}
