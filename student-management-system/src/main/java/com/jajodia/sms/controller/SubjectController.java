package com.jajodia.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jajodia.sms.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	//get all Subjects
	@GetMapping("/listOfSubjects")
	public String fetchAllSubjects(Model model)
	{
		model.addAttribute("subjects",subjectService.fetchAllSubjects());
		return "listOfSubjects";
	}
	
	@GetMapping("/subjectStudents/{id}")
	public String fetchAllStudentOfSubjects(@PathVariable int id,Model model)
	{
		model.addAttribute("nameOfSubject",subjectService.fetchSubjectName(id));
		model.addAttribute("students",subjectService.fetchStudentsBySubjects(id));
		return "listOfStudents";
	}

}
