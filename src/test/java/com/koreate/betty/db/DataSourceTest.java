package com.koreate.betty.db;


import java.sql.Connection;

import javax.sql.DataSource;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.koreate.betty.config.AppConfig;
import com.koreate.betty.config.DBConfig;
import com.koreate.betty.config.WebConfig;
import com.koreate.betty.domain.temp.Temp;
import com.koreate.betty.domain.temp.repo.TempRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class, DBConfig.class})
@WebAppConfiguration
public class DataSourceTest {
	
	@Autowired
	TempRepository dao;
	@Autowired
	DataSource ds;
	
	Temp temp1;
	Temp temp2;
	
	@Before
	public void init() {
		temp1.setID("tempId1");
		temp1.setPW("tempPw1");
		temp2.setID("tempId2");
		temp2.setPW("tempPw2");;
	}
	
	
	//@Test
	public void 히카리() throws InterruptedException {
			HikariConfig config = new HikariConfig("/prop/database.properties");
			config.setAutoCommit(false);
			config.setMaximumPoolSize(10);
			config.setMinimumIdle(1);
			ds = new HikariDataSource(config);
			
			Thread.sleep(1000);
	}
	
	@Transactional
	//@Test
	public void 트랜잭션() {
		
		Connection a = DataSourceUtils.getConnection(ds);
		DataSourceUtils.releaseConnection(a, ds);
		
		Connection b =DataSourceUtils.getConnection(ds);
		DataSourceUtils.releaseConnection(b, ds);
		
		Assertions.assertThat(b).isEqualTo(a);
	}
	
}



















