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
import com.koreate.betty.domain.board.dto.form.FreeBoardWriteForm;
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
public class FreeBoardRepoTest {

	@Autowired private WebApplicationContext wc;
	
	@Autowired private FreeBoardService freeBoardService;
	
	FreeBoardWriteForm form1;
	FreeBoardWriteForm form2;
	FreeBoardWriteForm form3;
	FreeBoardWriteForm ex;
	
	@Before
	public void init_data() {
		
		form1 = new FreeBoardWriteForm();
		form1.setMemberId("id001");
		form1.setTag("자유");
		form1.setTitle("제목 001");
		form1.setContent("내용 001");
		
		form2 = new FreeBoardWriteForm();
		form2.setMemberId("id002");
		form2.setTag("질문");
		form2.setTitle("제목 002");
		form2.setContent("내용 002");
		
		form3 = new FreeBoardWriteForm();
		form3.setMemberId("id003");
		form3.setTag("일상");
		form3.setTitle("제목 003");
		form3.setContent("내용 003");
		
		ex = new FreeBoardWriteForm();
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
	
	
}
