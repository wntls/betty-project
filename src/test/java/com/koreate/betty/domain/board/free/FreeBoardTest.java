package com.koreate.betty.domain.board.free;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.koreate.betty.domain.board.dto.FreeBoardForm;
import com.koreate.betty.domain.board.service.FreeBoardService;
import com.koreate.betty.domain.board.vo.FreeBoard;
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

	@Autowired
	private WebApplicationContext wc;

	private MockMvc mvc;
	
	@Autowired
	FreeBoardService freeBoardService;
	
	FreeBoardForm form1;
	FreeBoardForm form2;
	FreeBoardForm form3;
	FreeBoardForm ex;
	
	@Before
	public void init_data() {
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
		ex.setMemberId("exception");
		ex.setTag("tag");
		ex.setTitle("title");
		ex.setContent("content");
	}
	
	//@Test
	public void 컨텍스트_로드() throws InterruptedException {
		Thread.sleep(5000);
		log.info("complete");
	}
	
	@Test
	public void DAO_SAVE_AND_USE_GENERATED_KEY() {
		
		FreeBoard board1 = form1.createFreeBoard();
		FreeBoard board2 = form2.createFreeBoard();
		FreeBoard board3 = form3.createFreeBoard();
		
		int first = freeBoardService.write(board1);
		int second = freeBoardService.write(board2);
		int third = freeBoardService.write(board3);
		
		log.info("first={}, second={}, third={}",first,second,third);
	}
	
	//@Test
	public void DAO_SAVE_EXCEPTION () {
		FreeBoard exBoard = ex.createFreeBoard();
		int num = 0;
		try {
			num = freeBoardService.write(exBoard);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			log.info("num={}", num);
		}
		
		// SQLIntegrityConstraintViolationException
		// Blank와 NULL이 이미 차단된 상태.
		// 발생할 수 있는 제약 위반은 id가 없는 거 이외엔 없다.
		
	}
	
	
}
