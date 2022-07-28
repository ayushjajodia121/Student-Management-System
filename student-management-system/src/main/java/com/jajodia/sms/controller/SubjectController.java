package com.jajodia.sms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(SubjectController.class);
	
	//get all Subjects
	@GetMapping("/listOfSubjects")
	public String fetchAllSubjects(Model model)
	{
		logger.info("inside Subject Controller: fetchAllSubjects() method");
		logger.info("ListOfSubjects method is being called");
		model.addAttribute("subjects",subjectService.fetchAllSubjects());
		return "listOfSubjects";
	}
	
	@GetMapping("/subjectStudents/{id}")
	public String fetchAllStudentOfSubjects(@PathVariable int id,Model model)
	{
		logger.info("inside Subject Controller: fetchAllStudentOfSubjects() method");
		logger.info("fetching name of students enrolled in a subject ");
		model.addAttribute("nameOfSubject",subjectService.fetchSubjectName(id));
		model.addAttribute("students",subjectService.fetchStudentsBySubjects(id));
		return "listOfStudents";
	}
	
	@GetMapping("/subjectStudents/listOfSubjects")
	public String previousPage()
	{
		logger.info("inside Subject Controller: previousPage() method");
		logger.info("redirecting to listOfSubjects page");
		return "redirect:/listOfSubjects";
	}

}
