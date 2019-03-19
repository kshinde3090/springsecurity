package com.spring.security.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {
	
	@Autowired
	private Environment environment;
	//org.springframework.security.authentication.InternalAuthenticationServiceException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: Cannot create PoolableConnectionFactory (Access denied for user 'Me'@'localhost' (using password: YES))
	//org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is java.sql.SQLException: Cannot create PoolableConnectionFactory (Access denied for user 'Me'@'localhost' (using password: YES))
	
/*	@Bean
	public DataSource getDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(environment.getProperty("driver"));
		ds.setUrl(environment.getProperty("url"));
		ds.setPassword(environment.getProperty("password"));
		ds.setUsername(environment.getProperty("username"));
		return ds;
	}*/


	  @Bean
	  public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/test?allowPublicKeyRetrieval=true&useSSL=false");
	    dataSource.setUsername("root");
	    dataSource.setPassword("root");
	    return dataSource;
	  }
}
