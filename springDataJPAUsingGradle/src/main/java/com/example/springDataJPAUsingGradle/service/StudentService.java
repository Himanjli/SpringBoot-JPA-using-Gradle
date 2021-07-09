package com.example.springDataJPAUsingGradle.service;

import java.util.List;

import com.example.springDataJPAUsingGradle.entity.StudentEntity;


public interface StudentService {

	List<StudentEntity> getStudents();

	StudentEntity getStudent(long studentId);

	List<StudentEntity> getAllStudents();

	StudentEntity deleteStudent(long studentId);

	void addStudent(StudentEntity s);

	StudentEntity updateStudent(long studentId, StudentEntity s);

}
