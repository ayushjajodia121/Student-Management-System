package com.jajodia.sms;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jajodia.sms.entity.Student;
import com.jajodia.sms.service.StudentService;


@SpringBootTest
class StudentManagementSystemApplicationTests {

	@MockBean
	private StudentService studentService;
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om = new ObjectMapper();
	
	@Before(value = "mockMvc")
	private void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void addStudentTest() throws Exception {
		Student st = new Student();
		st.setFullName("Ayush");
		st.setStream("commercxe");
		st.setEmail("ayush");
		st.setContactNumber("654654654");
		
		String jsonRequest = om.writeValueAsString(st);
		MvcResult result = mockMvc.perform(post("/EmployeeService/addEmployee").content(jsonRequest).contentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
//		Response response = om.readValue(resultContent, Response.class);
//		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
		
	}
	
	@Test
	public void getStudentsList() throws Exception
	{
	
	}
}

//dscape:-to skip