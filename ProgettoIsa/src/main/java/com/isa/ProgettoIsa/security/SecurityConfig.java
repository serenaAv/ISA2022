package com.isa.ProgettoIsa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(final HttpSecurity http) throws Exception 
	{
    	http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated()
		.and()
        	.formLogin()
        	.loginPage("/login.html")
        	.failureUrl("/login-error.html")
			.usernameParameter("userId")
			.passwordParameter("pwd")
			.permitAll()
      	.and()
       		.logout()
        	.logoutSuccessUrl("/index.html");
	}
}
