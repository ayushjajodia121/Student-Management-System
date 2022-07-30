package com.jajodia.sms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jajodia.sms.entity.Student;
import com.jajodia.sms.service.StudentService;
import com.jajodia.sms.service.SubjectService;

@Controller

public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	
	@GetMapping("/allStudents")
	public String fetchAllStudents(Model model)
	{
		logger.info("inside Student Controller: fetchAllStudents() method");
		logger.info("fetching all enrolled students ");
//		String str = null;
//		System.out.println(str.length());
		model.addAttribute("students",studentService.fetchAllStudents());
		
		return "students";
	}
	
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value ="/allStudentsByName")
	public String fetchAllStudentsByName(Model model,String keyword)
	{
		logger.info("inside Student Controller: fetchAllStudentsByName() method");
		logger.info("fetching all enrolled students By name ");
		if(keyword!=null) {
		model.addAttribute("students",studentService.getStudentByName(keyword));
		return "student_by_name";}
		else {
			model.addAttribute("students",studentService.fetchAllStudents());
			return "students";
		}
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") Student student)
	{
		logger.info("inside Student Controller: addStudent() POST method");
		
		Student st=studentService.addStudent(student);
		if(st!=null)
		{
			logger.info("student saved successfully");
		}else {
			logger.warn("student not saved");
		}
		logger.info("redirecting to allStudents Page");
		return "redirect:/allStudents";
		
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model)
	{
		logger.info("inside Student Controller: addStudent() GET method");

		logger.info("redirecting to create_student.html page");
		Student st = new Student();
		model.addAttribute("student", st);
		model.addAttribute("subjects",subjectService.fetchAllSubjects());
		return "create_student";
	}
	
	@GetMapping("/editStudent/{id}")
	public String editStudentForm(@PathVariable int id, Model model)
	{
		logger.info("inside Student Controller: editStudentForm() GET method");

		model.addAttribute("student", studentService.fetchStudentByid(id));
		model.addAttribute("subjects",subjectService.fetchAllSubjects() );
		
		logger.info("redirecting to edit_student.html page");
		
		return "edit_student";
	}
	
	//get subjects associated with a particular student
	@GetMapping("/subjectsOfStudents/{id}")
	public String getSubjectsOfStudent(@PathVariable int id,Model model)
	{
		Student st = studentService.fetchStudentByid(id);
		model.addAttribute("subjects", st.getSubjects());
		return "listOfSubjects";
	}
	
	@PostMapping("/editStudent/{id}")
	public String editStudent(@PathVariable int id,@ModelAttribute("student") Student student)
	{
		logger.info("inside Student Controller: editStudent() POST method");
		studentService.updateStudent(id, student);
		
		logger.info("redirecting to students.html page after updating details");

		return "redirect:/allStudents";
	}
	 
	@GetMapping("deleteStudent/{id}")
	public String deleteStudentById(@PathVariable int id)
	{
		studentService.deleteStudentById(id);
		return "redirect:/allStudents";
	}
	
	@GetMapping("/pendingFeesStudents")
	public String fetchPendingFeeStudent(Model model)
	{
		model.addAttribute("pendingStudents",studentService.fetchPendingFeeStudent(false));
		return "pending_fees";
	}
	
	@GetMapping("/editStatus/{id}")
	public String updateStatus(@PathVariable int id)
	{
		studentService.updateStatus(id);
		return "redirect:/pendingFeesStudents";
	}
	
	
	
//	@GetMapping("/editStudent/allStudents")
//	public String fetchStudents()
//	{
//		return "redirect:/allStudents";
//	}

	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Model m)
	{
		m.addAttribute("msg", "Exception has occured");
		return "exception-page";
	}
	

}
