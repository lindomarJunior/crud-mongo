package com.crudmongo.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UsersConfigMongo usersConfigMongo;
		
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		//desabilitação fo CSRF para que possa ser usado o POST no postman
		/*http.csrf().disable();*/
		
		/*Configuração: para todos os requests o usuário deve etar 
		autenticado através de um formulário de login	*/	
		http.authorizeRequests()
		.antMatchers("/Admin").hasAuthority("ADMIN")//Permissão específica de admin para página administração
		.antMatchers("/Gerencia").hasAuthority("GERENTE")//Permissão específica de gerente para página gerencia
		.antMatchers("/Cliente").hasAuthority("CLIENTE")//Permissão específica de admin para página cliente
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/Login").permitAll()
		.and()
		.logout().logoutSuccessUrl("/Login?logout").permitAll();
    }
	
  
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		//Usuário e senha setados em através de banco de dados usando o mongoDB
		builder.userDetailsService(usersConfigMongo);
	}
	
	//Usuário e senha setados em memoria
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
		.withUser("junior").password("{noop}123").roles("GERENTE", "ADMIN")
		.and()
		.withUser("joao").password("{noop}123").roles("CLIENTE");
	}*/
}
