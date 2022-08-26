package com.koreate.betty.domain.board.free;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.koreate.betty.domain.board.dto.form.FreeBoardCommentForm;
import com.koreate.betty.domain.board.dto.form.FreeBoardForm;
import com.koreate.betty.domain.board.service.FreeCommentService;
import com.koreate.betty.domain.board.vo.FreeBoard;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, AppConfig.class, RootConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class FreeBoardCommentRepoTest {
	
	@Autowired 
	private WebApplicationContext wc;
	
	@Autowired
	private FreeCommentService fc;
	
	FreeBoardCommentForm form1;
	FreeBoardCommentForm form2;
	FreeBoardCommentForm form3;
	FreeBoardCommentForm form4;
	
	FreeBoardForm form5;
	
	
	@Before
	public void init() {
		form1 = new FreeBoardCommentForm();
		form1.setOrigin(0);
		form1.setDepth(0);
		form1.setSeq(0);
		form1.setFreeBno(30);
		form1.setMemberId("id002");
		form1.setComment("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
		form5 = new FreeBoardForm();
		form5.setBno(30);
	}
	
	@Test
	public void add() {
		FreeBoard board = form5.createFreeBoard();
		int re = fc.add(form1, board);
		log.info("re={}",re);
	}
	
	
	
}
























