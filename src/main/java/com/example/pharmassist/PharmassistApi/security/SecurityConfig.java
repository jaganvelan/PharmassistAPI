package com.example.pharmassist.PharmassistApi.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return  new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(authorize-> authorize
				.requestMatchers("/register","./login").permitAll()
				.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults()) // inbuilt session based authentication mrechanism used by spring security
		.build();
	}
}
