package com.koreate.betty.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import com.koreate.betty.annotation.DatabaseConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@DatabaseConfiguration
@MapperScan(basePackages = { "com.koreate.betty.domain" })
public class DBConfig {

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig("/database.properties");
		return new HikariDataSource(config);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		
		Configuration config = new Configuration();
		config.setMapUnderscoreToCamelCase(true);
		bean.setConfiguration(config);
		
		bean.setDataSource(ds);
		bean.setTypeAliasesPackage("com.koreate.betty.domain");
		return bean.getObject();
	}

	@Bean
	public TransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
}
