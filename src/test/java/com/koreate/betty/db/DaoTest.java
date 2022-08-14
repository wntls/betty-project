package com.koreate.betty.db;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.koreate.betty.domain.temp.dao.TempRepository;
import com.koreate.betty.domain.temp.vo.Temp;
import com.koreate.betty.global.config.AppConfig;
import com.koreate.betty.global.config.RootConfig;
import com.koreate.betty.global.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, RootConfig.class, AppConfig.class })
@WebAppConfiguration
public class DaoTest {

	@Autowired
	TempRepository dao;
	
	
	@Test
	//@Transactional
	public void insert_test() {
		Temp temp = new Temp();
		temp.setID("tempId");
		temp.setPW("tempPw");
		int result = dao.insert(temp);
		log.error("result = {}", result);
	}
	
	
	
}
