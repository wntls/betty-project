package com.koreate.betty.domain.board.notice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.koreate.betty.domain.board.dto.form.NoticeBoardForm;
import com.koreate.betty.domain.board.service.NoticeBoardService;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class, AppConfig.class, RootConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class NoticeBoardRepoTest {
	
	@Autowired 
	private WebApplicationContext wc;
	
	@Autowired
	private NoticeBoardService ns;
	
	NoticeBoardForm form1;
	NoticeBoardForm form2;
	NoticeBoardForm form3;
	NoticeBoardForm form4;
	
	
	@Before
	public void init() {
		form1 = new NoticeBoardForm();
		form1.setMemberId("id001");
		form1.setTitle("타이틀");
		form1.setContent("콘텐츠");
		
		form2 = new NoticeBoardForm();
		form2.setBno(1);
		
		form3 = new NoticeBoardForm();
		form3.setTitle("수정했다");
		form3.setContent("수정했다고");
		form3.setBno(2);
		
	}
	
	//@Test
	public void add() {
		int f = ns.write(form1);
		log.info("f={}",f);
	}
	
	//@Test
	public void remove() {
		int t = ns.remove(form2);
		log.info("t={}",t);
	}
	
	@Test
		public void modify() {
			int t = ns.update(form3);
			log.info("t={}",t);
		}
	
}






























