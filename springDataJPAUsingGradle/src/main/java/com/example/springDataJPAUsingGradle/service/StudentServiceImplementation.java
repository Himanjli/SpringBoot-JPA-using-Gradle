package com.example.springDataJPAUsingGradle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springDataJPAUsingGradle.Dao.StudentDao;
import com.example.springDataJPAUsingGradle.entity.StudentEntity;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<StudentEntity> getStudents() {
		return studentDao.findByActiveTrue();
	}

	@Override
	public StudentEntity getStudent(long studentId) {
		return studentDao.findById(studentId).get();
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public StudentEntity deleteStudent(long studentId) {
		StudentEntity s = studentDao.findById(studentId).get();
		s.setActive(false);
		studentDao.save(s);
		return s;
	}

	@Override
	public void addStudent(StudentEntity s) {
		// TODO Auto-generated method stub
		s.setActive(true);
		studentDao.save(s);
	}

	@Override
	public StudentEntity updateStudent(long studentId, StudentEntity s) {
		StudentEntity stu = studentDao.findById(studentId).get();
		stu.setName(s.getName());
		stu.setCourse(s.getCourse());
		stu.setPhoneNumber(s.getPhoneNumber());
		studentDao.save(stu);
		return stu;
	}
	
	

}
