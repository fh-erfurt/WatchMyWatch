package de.watchmywatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/bracelets").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/bracelets").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/bracelets").permitAll()
                .antMatchers(HttpMethod.POST, "/api/clockworks").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/clockworks").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/clockworks").permitAll()
                .antMatchers(HttpMethod.POST, "/api/casings").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/casings").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/casings").permitAll()
                .antMatchers(HttpMethod.POST, "/api/watches").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/watches").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/watches").permitAll()
                .antMatchers(HttpMethod.POST, "/api/manufacturers").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/manufacturers").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/manufacturers").permitAll().and()
        .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //Web resources
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/scripts/**");
        web.ignoring().antMatchers("/images/**");
    }
}


