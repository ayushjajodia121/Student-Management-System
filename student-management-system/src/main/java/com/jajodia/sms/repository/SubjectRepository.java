package com.jajodia.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jajodia.sms.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	

}
