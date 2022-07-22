package com.jajodia.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jajodia.sms.entity.Student;
import com.jajodia.sms.entity.Subject;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByFullName(String name);
	
	public List<Student> findByFullNameContaining(String name );
	
	@Query("SELECT s from Student s where s.fees = :status")
	public List<Student> findStudentByFeeStatus(@Param("status") boolean status);

	@Query("SELECT s FROM Subject s WHERE s.subjectId IN (:sl)")
	public List<Subject> findSubjectByIds(@Param("sl") List<Integer> sl);
	
//	@Query("SELECT st FROM Student st where st.subjectId=:sl")
//	public List<Student> fetchStudentSubjects(@Param("sl") Integer sl);
	
	@Query("Select st from Student st INNER JOIN st.subjects sub WHERE sub.subjectId=:sl")
	public List<Student> fetchStudentsBySubjects(@Param("sl") Integer sl);
	
//	@Query("SELECT st FROM Student st where st.id IN (SELECT sb.id FROM Subject sb WHERE )")
//	public List<Student> fetchStudentsBySubjects(@Param("sl") Integer sl);
//	
//	@Query("SELECT * FROM Student WHERE id IN (select id from Student.Subject WHERE subjectId= :sl)")
//	public List<Student> fetchStudentsBySubjects(@Param("sl") Integer sl);
	

}
