package com.jajodia.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jajodia.sms.entity.Student;
import com.jajodia.sms.entity.Subject;
import com.jajodia.sms.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	//add a student to database
	public Student addStudent(Student student)
	{
//		studentRepository.addAddress()
		return studentRepository.save(student);
	}
	//fetch All Students
	public List<Student> fetchAllStudents()
	{
		return studentRepository.findAll();
	}
	
	//fetch individual student by Id
	public Student fetchStudentByid(int id)
	{
		return studentRepository.findById(id).orElseThrow(null);
	}
	
	//update Student by Id
	public Student updateStudent(int id,Student st)
	{
		Student stOld = studentRepository.findById(id).orElseThrow(null);
		if(stOld==null)
		{
			return null;
		}
		else
		{
			stOld.setId(st.getId());
			stOld.setFullName(st.getFullName());
			stOld.setEmail(st.getEmail());
			stOld.setContactNumber(st.getContactNumber());
			stOld.setStream(st.getStream());
			stOld.setFees(st.isFees());
			return studentRepository.save(stOld);
		}
	}
	
	//delete Student By Id
	public String deleteStudentById(int id)
	{
	 studentRepository.deleteById(id);
	 return "Student Deleted Successfully";
	}
	
	//get Student detail by name 
	public List<Student> getStudentByName(String name)
	{
		return studentRepository.findByFullNameContaining(name);
	}
	
	//get all students whose fees is pending
	public List<Student> fetchPendingFeeStudent(boolean status)
	{
		return studentRepository.findStudentByFeeStatus(status);
	}
	
	//update fees status
	public Student updateStatus(int id) {
		Student stOld = studentRepository.findById(id).orElseThrow(null);
		stOld.setFees(true);
		return studentRepository.save(stOld);
		
	}
	
	//add subjects to a student
	public Student addSubjects(int id,List<Integer> ids)
	{
		Optional<Student> stuOpt = studentRepository.findById(id);
		if(!stuOpt.isPresent()) {
			throw new RuntimeException("Student not available");
		}
		Student studentOld = stuOpt.get();
		List<Subject> subjects = studentRepository.findSubjectByIds(ids);
		studentOld.setSubjects(subjects);
		return studentRepository.save(studentOld);
	}

}
