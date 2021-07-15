package com.lexmatos.msdiary.user;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// https://www.baeldung.com/spring-boot-testing

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.yml")
class UserControllerTest {

	@Autowired
    private MockMvc mvc;

	@Test
	public void findAll() throws Exception {

     	mvc.perform(get("/users")
       		.contentType(MediaType.APPLICATION_JSON))
       		.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].name").value("Michael Jackson"));
	}


	@Test
	public void findById() throws Exception {

     	mvc.perform(get("/users/2")
       		.contentType(MediaType.APPLICATION_JSON))
       		.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name").value("Alan Conceição"));
	}	
}
 