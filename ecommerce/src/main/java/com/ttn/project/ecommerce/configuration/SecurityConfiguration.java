package com.ttn.project.ecommerce.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/register-customer").permitAll()
//                .antMatchers("/confirm-customer").permitAll();

        http.httpBasic().disable();
    	http.csrf().disable() .authorizeRequests() .anyRequest().permitAll();
    }
}
