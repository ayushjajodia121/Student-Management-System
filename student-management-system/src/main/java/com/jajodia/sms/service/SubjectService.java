package com.jajodia.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jajodia.sms.entity.Student;
import com.jajodia.sms.entity.Subject;
import com.jajodia.sms.repository.StudentRepository;
import com.jajodia.sms.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	//add new subject
	public Subject addSubject(Subject sub)
	{
		return subjectRepository.save(sub);
	}
	
	//update existing course
	public Subject updateSubject(int id,Subject sub)
	{
		Subject old = subjectRepository.findById(id).orElseThrow(null);
		old.setName(sub.getName());
		old.setSemester(sub.getSemester());
		return subjectRepository.save(old);
	}
	
	//get all Available Subjects
	public List<Subject> fetchAllSubjects()
	{
		return subjectRepository.findAll();
	}
	
	//delete specific subjects
	public void deleteById(int id)
	{
		Subject sub = subjectRepository.findById(id).orElseThrow(null);
		subjectRepository.delete(sub);
	}
	
	//fetch Students from a particular subjects
	public List<Student> fetchStudentsBySubjects(int id)
	{
		return studentRepository.fetchStudentsBySubjects(id);
	}

	public String fetchSubjectName(int id) {
		Subject sb = subjectRepository.findById(id).orElseThrow(null);
		String name=sb.getName();
		return name;
	}
	
	

}
