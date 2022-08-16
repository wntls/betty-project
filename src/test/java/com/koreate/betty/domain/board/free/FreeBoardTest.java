package com.koreate.betty.domain.board.free;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koreate.betty.domain.board.dto.FreeBoardDto;
import com.koreate.betty.domain.board.dto.form.FreeBoardForm;
import com.koreate.betty.domain.board.service.FreeBoardService;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, AppConfig.class, RootConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class FreeBoardTest {

	@Autowired private WebApplicationContext wc;
	
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired private FreeBoardService freeBoardService;
	
	FreeBoardForm form1;
	FreeBoardForm form2;
	FreeBoardForm form3;
	FreeBoardForm ex;
	
	@Before
	public void init_data() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
		
		form1 = new FreeBoardForm();
		form1.setMemberId("id001");
		form1.setTag("자유");
		form1.setTitle("제목 001");
		form1.setContent("내용 001");
		
		form2 = new FreeBoardForm();
		form2.setMemberId("id002");
		form2.setTag("질문");
		form2.setTitle("제목 002");
		form2.setContent("내용 002");
		
		form3 = new FreeBoardForm();
		form3.setMemberId("id003");
		form3.setTag("일상");
		form3.setTitle("제목 003");
		form3.setContent("내용 003");
		
		ex = new FreeBoardForm();
		ex.setMemberId("none");
		ex.setTag("tag");
		ex.setTitle("title");
		ex.setContent("content");
	}
	
	//@Test
	public void 컨텍스트_로드() throws InterruptedException {
		Thread.sleep(5000);
		log.info("complete");
	}
	
	//@Test
	public void DAO_SAVE_AND_USE_GENERATED_KEY() {
		
		int first = freeBoardService.write(form1);
		int second = freeBoardService.write(form2);
		int third = freeBoardService.write(form3);
		
		log.info("first={}, second={}, third={}",first,second,third);
	}
	
	@Test // 실패
	public void 사이즈_예외_터뜨리기() throws Exception {
		log.info("WebApplicationContext wc = {}", wc);
		log.info("MockMvc mvc = {}", mockMvc);
		
		FreeBoardDto dto = new FreeBoardDto();
		dto.setMemberId("id001");
		dto.setTitle("제목");
		dto.setTag("0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 ");
		dto.setContent("에러");
		
		String dtoToJson = objectMapper.writeValueAsString(dto);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/boards/free/new")
								.contentType(MediaType.APPLICATION_JSON)
								.content(dtoToJson))
								.andReturn();
		System.out.println("*****************"+result.getResponse().getContentAsString());
		
		
	}
}
