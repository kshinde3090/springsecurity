package com.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
	    PasswordEncoder passwordEncoder;
		
		@Autowired
		DataSource dataSource;
	 
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    /*	auth.inMemoryAuthentication()
	        .passwordEncoder(passwordEncoder)
	        .withUser("user").password(passwordEncoder.encode("123456")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");
	        */
	    	
	    	auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery("select username, password, enabled"
	            + " from users where username=?")
	        .authoritiesByUsernameQuery("select username, authority "
	            + "from authorities where username=?")
	        .passwordEncoder(passwordEncoder);
	    }
	 
	    
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        .antMatchers("/login").permitAll()
	        .antMatchers("/admin/**").hasRole("ADMIN")
	        .antMatchers("/**").hasAnyRole("ADMIN", "USER")
	        .and().formLogin()
	        .and().logout().logoutSuccessUrl("/login").permitAll()
	        .and().csrf().disable();
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	
	
	
	
	
}
