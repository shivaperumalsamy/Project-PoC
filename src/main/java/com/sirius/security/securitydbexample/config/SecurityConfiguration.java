package com.sirius.security.securitydbexample.config;

import com.sirius.security.securitydbexample.repository.UsersRepository;
import com.sirius.security.securitydbexample.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService)
       .passwordEncoder(getPasswordEncoder());
        
 
    }
    


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
//        http.authorizeRequests()
//        			.antMatchers("**/login/**").permitAll().
//        			.and()
//                .antMatchers("**/secured/**").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin().permitAll();
        

//        http
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated().and()
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                //.antMatchers("**/rest/*")
//                //.and()
//                //.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
//                .httpBasic();
//        http.csrf().disable();
        
        http
        .formLogin()
        .loginPage("/login.html")
        .failureUrl("/login-error.html")
    .and()
        .logout()
        .logoutSuccessUrl("/index.html")
    .and()
        .authorizeRequests()
        .antMatchers("/admin/**").hasAnyRole("ADMIN","OPERATOR")
        .antMatchers("/user/**").hasRole("USER")
        .antMatchers("/shared/**").hasAnyRole("USER","ADMIN")
    .and()
        .exceptionHandling()
        .accessDeniedPage("/403.html");

    
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }
}
