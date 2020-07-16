package de.watchmywatch.config;

import de.watchmywatch.repository.storage.UserDetail.SecurityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    SecurityDetailsService securityDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                // The pages does not require login
                .antMatchers("/","/login","/logout","/register","/newUser","/index").permitAll()
               /* .antMatchers(HttpMethod.POST, "/api/bracelets").permitAll()
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
                .antMatchers(HttpMethod.DELETE, "/api/manufacturers").permitAll().and()*/
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // our own Login-Page
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                // When the user has logged in as XX.
                // But access a page that requires role YY,
                // AccessDeniedException will be thrown.
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .logout()
                .permitAll();


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //Web resources
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/scripts/**");
        web.ignoring().antMatchers("/images/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Setting Service to find User in the database.
        auth.userDetailsService(securityDetailsService);
    }



}


