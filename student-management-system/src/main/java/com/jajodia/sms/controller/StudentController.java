package com.jajodia.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jajodia.sms.entity.Student;
import com.jajodia.sms.service.StudentService;
import com.jajodia.sms.service.SubjectService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/allStudents")
	public String fetchAllStudents(Model model)
	{
		model.addAttribute("students",studentService.fetchAllStudents());
		
		return "students";
	}
	
	@GetMapping("/allStudentsByName")
	public String fetchAllStudentsByName(Model model,String keyword)
	{
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
		studentService.addStudent(student);
		return "redirect:/allStudents";
		
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model)
	{
		Student st = new Student();
		model.addAttribute("student", st);
		model.addAttribute("subjects",subjectService.fetchAllSubjects());
		return "create_student";
	}
	
	@GetMapping("/editStudent/{id}")
	public String editStdentForm(@PathVariable int id, Model model)
	{
		model.addAttribute("student", studentService.fetchStudentByid(id));
		return "edit_student";
	}
	
	@PostMapping("/editStudent/{id}")
	public String editStudent(@PathVariable int id,@ModelAttribute("student") Student student)
	{
		studentService.updateStudent(id, student);
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
	
	@GetMapping("/editStudent/allStudents")
	public String fetchStudents()
	{
		return "redirect:/allStudents";
	}
	
	

}
