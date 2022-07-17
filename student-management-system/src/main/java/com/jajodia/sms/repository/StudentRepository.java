package com.jajodia.sms.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jajodia.sms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByFullName(String name);
	
	public List<Student> findByFullNameContaining(String name );
	
	@Query("SELECT s from Student s where s.fees = :status")
	public List<Student> findStudentByFeeStatus(@Param("status") boolean status);
	

}
