package com.jajodia.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jajodia.sms.entity.Student;
import com.jajodia.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
//		Student st1=new Student("Ayush Jajodia","Electronics","ayushjajodia121@gmail.com","6377380147");
//		Student st2=new Student("Anjali Mukherji","Electronics","anjali9@gmail.com","6969696969");
//		Student st3=new Student("Aditi Jain","Electronics","aditi1719@gmail.com","969696969696");
////		studentRepository.save(st1);
//		studentRepository.save(st2);
//		studentRepository.save(st3);
	}

}
