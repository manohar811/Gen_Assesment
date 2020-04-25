package com.example.book.integrationtest;

import java.awt.PageAttributes.MediaType;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.http.MediaType;

import com.example.book.app.BookApplication;
import com.example.book.persistence.BookRepository;
import com.example.book.service.BookService;

@RunWith(SpringRunner.class)

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
		classes = BookApplication.class)
@ContextConfiguration(classes=BookApplicationIntTests.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class BookApplicationIntTests {
	
	
	@Autowired
	MockMvc mockMVC;

	@Test
	void contextLoads() throws Exception {
		
		
		/*Mockito.when(bookRepository.findAll()).thenReturn(Collections.emptyList());*/
		
		MvcResult mvcResult = mockMVC.perform(MockMvcRequestBuilders.get("/all").accept(org.springframework.http.MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		System.out.println(mvcResult.getResponse());
		
		
		//Mockito.verify(bookRepository).findAll();
		
		
		
	}

}
