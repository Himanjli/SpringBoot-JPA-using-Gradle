package com.example.springDataJPAUsingGradle.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springDataJPAUsingGradle.entity.StudentEntity;

public interface StudentDao extends JpaRepository<StudentEntity, Long> {

	List<StudentEntity> findByActiveTrue();
	
	//or
//	@Query("Select s from Student s where s.active = :flag")
//	List<Student> findAllActiveUsers(@Param("flag") boolean flag);
}
