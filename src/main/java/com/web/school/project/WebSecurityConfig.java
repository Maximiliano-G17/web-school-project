package com.web.school.project;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/views/users/").permitAll()
		.antMatchers("/api/people/students/").permitAll()
		.antMatchers("/api/people/teachers/").permitAll()
		.antMatchers("/api/people/subjects/").permitAll()
		.antMatchers("/api/people/directors/").permitAll()
		.antMatchers("/api/people/teachers/**").permitAll()
		.antMatchers("/api/people/subjects/**").permitAll()
		.antMatchers("/api/people/students/register").hasAuthority("ADMIN")
		.antMatchers("/api/people/students/postRegister").hasAuthority("ADMIN")
		.antMatchers("/api/people/students/update/**").hasAuthority("ADMIN")
		.antMatchers("/api/people/students/delete/**").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/api/people/error403");
	}

	@Autowired
	public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passEncoder)
		.usersByUsernameQuery("SELECT user,password,'true' as enabled FROM rol WHERE user = ?")	
		.authoritiesByUsernameQuery("SELECT r.user,p.rol FROM persons p INNER JOIN rol r ON r.user=p.rol WHERE r.user = ?");
	}
}