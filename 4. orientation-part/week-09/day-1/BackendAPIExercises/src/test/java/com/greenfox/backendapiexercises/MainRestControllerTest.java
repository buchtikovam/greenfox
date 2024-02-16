package com.greenfox.backendapiexercises;

import com.greenfox.backendapiexercises.controllers.MainRestController;
import com.greenfox.backendapiexercises.repositories.LogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MainRestControllerTest {

	private MockMvc mockMvc;

	@Mock
	private LogRepository logRepository;

	@InjectMocks
	private MainRestController mainRestController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mainRestController).build();
	}

	// Doubling exercise
	@Test
	void testDoubleNum() throws Exception {
		mockMvc.perform(get("/doubling").param("input", "5"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.received").value(5))
			.andExpect(jsonPath("$.result").value(10));
	}

	@Test
	void testDoubleNumWithError() throws Exception {
		mockMvc.perform(get("/doubling"))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.error").value("Please provide an input!"));
	}




	// Greeter exercise
	@Test
	void testGreet() throws Exception {
		mockMvc
			.perform(get("/greeter")
				.param("name", "John")
				.param("title", "teacher"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.welcome_message")
				.value("Oh, hi there John, my dear teacher!")
			);
	}

	@Test
	void testGreetWithError() throws Exception {
		mockMvc
			.perform(get("/greeter"))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.error")
				.value("Please provide a name and a title!")
			);
	}



	// AppendA exercise
	@Test
	void testAppendA() throws Exception {
		mockMvc
			.perform(get("/appenda/{appendable}", "test"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.appended")
				.value("testa")
			);
	}

	@Test
	void testAppendAWithError() throws Exception {
		mockMvc
			.perform(get("/appenda/"))
			.andExpect(status().isNotFound())
			.andExpect(jsonPath("$.error").value("No string provided"))
			.andReturn();
	}
}