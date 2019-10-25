/**
 * 
 */
package com.security.jwt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.security.jwt.repository.UserRepository;

/**
 * @author alexsurya
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserPrincipalDetailsService userPrincipalDetailsService;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		 * auth .inMemoryAuthentication()
		 * .withUser("alex").password(passwordEncoder().encode("alex")).authorities(
		 * "API_1", "ROLE_ADMIN") .and()
		 * .withUser("surya").password(passwordEncoder().encode("surya")).authorities(
		 * "API_2","ROLE_USER");
		 */
		auth	
			.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * http .authorizeRequests() .antMatchers("/jwt/hello").permitAll()
		 * .antMatchers("/jwt/index").hasRole("USER")
		 * .antMatchers("/jwt/admin").hasRole("ADMIN")
		 * .antMatchers("/jwt/api/test1").hasAuthority("API_1")
		 * .antMatchers("/jwt/api/user/list").hasRole("ADMIN") .and() .httpBasic();
		 */
		JwtAuthenticatinFilter filter = new JwtAuthenticatinFilter(authenticationManager());
		filter.setFilterProcessesUrl("/jwt/login");
		http	
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(filter)
			.addFilter(new JwtAuthenticatinFilter(authenticationManager()))
			.addFilter(new JwtAuthorizationFilter(authenticationManager() , userRepository))
			.authorizeRequests()
			.antMatchers("/jwt/hello").permitAll()
			.antMatchers("/jwt/admin/**").hasRole("ADMIN")
			.antMatchers("/jwt/api/**").hasRole("USER")
			.antMatchers("/view/**").hasRole("USER");
	}
	
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
		return daoAuthenticationProvider;
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
