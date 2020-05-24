package com.tms.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("com.tms.*")
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
               .antMatchers("/registration").permitAll()
               .antMatchers("/user_page").authenticated()
               .antMatchers("/admin_page").hasRole("ADMIN")
               .antMatchers("/admin_user_info").hasRole("ADMIN")
               .antMatchers("/admin_pcgame_info").hasRole("ADMIN")
            .and()
               .formLogin()
               .loginPage("/login")
               .loginProcessingUrl("/perform_login")
               .defaultSuccessUrl("/user_page")
            .and()
                .logout()
            .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
            .and()
                .cors().disable();

    }
}
