package test;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@TransactionConfiguration
@Transactional
@WebAppConfiguration
public class BoardControllerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void getSelectedQuestion() throws Exception {
		MvcResult result = mockMvc.perform(
				get("/board/question")
				.param("id", "1")
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8"))
		.andDo(print()).andReturn();
		
		String json = result.getResponse().getContentAsString();
		System.out.println(json);
	}
	
	
	@Test
	public void listpage_test() throws Exception {
		MvcResult result = mockMvc.perform(
				get("/board/listpage")
				.param("page", "0")
				.param("category", "Education")
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8"))
		.andDo(print()).andReturn();
		
		String json = result.getResponse().getContentAsString();
		System.out.println(json);
	}
	@Test
	public void getQuestionCount() throws Exception {
		MvcResult result = mockMvc.perform(
				get("/board/questioncount")
				.param("category", "Education")
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8"))
		.andDo(print()).andReturn();
		
		String json = result.getResponse().getContentAsString();
		System.out.println(json);
	}
}
