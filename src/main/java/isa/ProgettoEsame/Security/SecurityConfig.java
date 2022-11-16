package isa.ProgettoEsame.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import isa.ProgettoEsame.service.UserDetailsServiceImpl;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService(){
		return new UserDetailsServiceImpl();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncoder());
		authProvider.setUserDetailsService(userDetailsService);
		return authProvider;
	}

	@Autowired
	UserDetailsService userDetailsService;

	@Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());

    }

	@Override
	protected void configure( HttpSecurity http) throws Exception 
	{
    	http
			.csrf().disable()
			.authorizeRequests()
								.antMatchers("/link/add", "/link/edit/{id}").hasAuthority("admin")
								.antMatchers("/login", "/registration", "/saveUser_reg").permitAll()
								//.antMatchers("/index").hasRole("ADMIN")
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
	// se voglio modificare la pagina 403 che viene fuori
	//	.and()
	//		.exceptionHandling().accessDeniedPage("/403");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
