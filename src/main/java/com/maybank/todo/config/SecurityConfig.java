package com.maybank.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf().disable()
//		.authorizeRequests().antMatchers("/login", "/hello", "/").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/login")
//		.permitAll()
//		.defaultSuccessUrl("/hello")
//		.and()
//		.logout().invalidateHttpSession(true)
//		.clearAuthentication(true)
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutSuccessUrl("/hello")
//		.permitAll();
		
//		http
//		.authorizeRequests()
//		.antMatchers("/","/register").permitAll()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/login")
//		.defaultSuccessUrl("/dashboard")
//		.permitAll()
//		.and()
//        .logout()
//        .permitAll()
//        .and().csrf().disable();
		
		http
		.authorizeRequests()
		.antMatchers("/","/register").permitAll()
		.antMatchers("/todo/edit/**","/todo/delete/**").hasAuthority("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/todo/list-all")
		.permitAll()
		.and()
        .logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login")
        .permitAll()
        .and().csrf().disable();
		
	}

	
}
