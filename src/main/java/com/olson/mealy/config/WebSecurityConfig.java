package com.olson.mealy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((auth) -> auth // allows/restricts access by request
				.requestMatchers("/home", "/meals/**").authenticated() // restrict access to all routes
				.anyRequest().permitAll() // allow any request
				)
			.formLogin((formLogin) -> formLogin // specifies login will be via a FORM
				.permitAll()
				.loginPage("/login") // sends users to this url if login is required
				.defaultSuccessUrl("/home")
				)
			.logout((logOut) -> logOut
				.deleteCookies("remove")
				.invalidateHttpSession(false)
				.logoutSuccessUrl("/login")
				);
		
		return http.build();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    } 
}
