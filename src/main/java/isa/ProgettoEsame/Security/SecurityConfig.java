package isa.ProgettoEsame.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

	@Override
	protected void configure( HttpSecurity http) throws Exception 
	{
    	http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
								.antMatchers("/registration").permitAll()
								.antMatchers("/index").hasRole("ADMIN")
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

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
}
