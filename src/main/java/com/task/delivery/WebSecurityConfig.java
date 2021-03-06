package com.task.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                    .antMatchers("/resources/**", "/registration").permitAll()
                    .antMatchers("/docs/**").permitAll()
                    .antMatchers("/support/**").permitAll()
                    .antMatchers("/about/**").permitAll()
                    .antMatchers("/blog/**").permitAll()
                //    .antMatchers("/dashboard/**").permitAll()
                 //     .antMatchers("/project/**").permitAll()
                    .antMatchers("/dashboard/**").authenticated()
                    .antMatchers("/project/**").authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/dashboard")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
       // auth.inMemoryAuthentication()
       //         .withUser("admin").password("admin")
        //        .authorities("ROLE_USER");
    }

}