package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*
 *  we need AuthenticationManager to configure spring sec
 *      				|
	to configure AuthenticationManager this we need AuthenticationManagerBuilder (in java config)
				 |
	to get AuthenticationManagerBuilder we have to extends a class whose name is 
				|
				configure(AuthenticationManagerBuilder ab){
				}
		WebSecurityConfigurerAdapter

 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.config"})
public class SecCofig extends WebSecurityConfigurerAdapter {

	//authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("raj").password("raj123").roles("ADMIN")
		.and()
		.withUser("ekta").password("ekta123").roles("MGR")
		.and()
		.withUser("gun").password("gun123").roles("EMP");
	}

	//{noop}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();// spring sec hey dont use it
	}
	

	//this method is used to bypass some static resouces
	@Override
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring().antMatchers("/resources/**");
	}

	//autherization : who can access what?
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin().loginPage("/showLoginPage")
		.loginProcessingUrl("/loginprocess")
		.permitAll();
	}

	
	
}









