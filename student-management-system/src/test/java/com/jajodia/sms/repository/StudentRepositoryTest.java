package com.jajodia.sms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jajodia.sms.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	void testFindByFullName() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByFullNameContaining() {
		List<Student> ActualSt = studentRepository.findByFullNameContaining("Ayush");
//		List<Student> expectedSt = [{"fullName":"Ayush","stream":"Electronics","email":"ayushjajodia121@gmail.com","contactNumber":"6666666666","subjects":""}];
		assertThat(ActualSt).hasSize(2)
							.extracting(Student::getStream)
							.contains("Electronics");
		final List<Student> copyOfStudents = List.of(ActualSt.get(1),ActualSt.get(0));
		assertThat(ActualSt).hasSameElementsAs(copyOfStudents);
		
	}
//	@AfterEach
//	void tearDown() {
//		studentRepository.deleteAll();
//	}

	@Test
	void testFindStudentByFeeStatus() {
		fail("Not yet implemented");
	}

	@Test
	void testFindSubjectByIds() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchStudentsBySubjects() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll1() {
		fail("Not yet implemented");
	}

}
