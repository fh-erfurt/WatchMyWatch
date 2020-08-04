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
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityDetailsService securityDetailsService;

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityDetailsService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                // The pages does not require login
                .antMatchers("/","/login","/logout","/register","/newUser","/index", "/swagger-ui.html",
                        "/v2/api-docs", "/swagger-resources", "/api/**").permitAll()
                .antMatchers("/greeting").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // our own Login-Page
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/loginSuccessfull",true)
                .permitAll()
                .and()
                // When the user has logged in as XX.
                // But access a page that requires role YY,
                // AccessDeniedException will be thrown.
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .logout()
                .logoutRequestMatcher( new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index");



    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //Web resources
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/scripts/**");
        web.ignoring().antMatchers("/images/**");
        web.ignoring().antMatchers("/webjars/**");

    }




}


