package bank.project.app;

import bank.project.app.login.CustomerLoginFailureHandler;
import bank.project.app.login.CustomerLoginSuccessHandler;
import bank.project.dao.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class BankSecurity {

//autowire service class, success and failure handlers
@Autowired
BankService bankService;

AuthenticationManager authenticationManager;

@Autowired
CustomerLoginSuccessHandler successHandler;

@Autowired
CustomerLoginFailureHandler failureHandler;

@Bean
public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
        }

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests((requests)->{
                //authorize only for following requests
                requests.antMatchers("/resources/static/images/**").permitAll();
                requests.antMatchers("/web/login").permitAll();
                requests.antMatchers("/web/dash").authenticated();
                requests.antMatchers("/web/pay").authenticated();
        });

        httpSecurity.logout().permitAll();
        httpSecurity.formLogin().loginPage("/web/login").usernameParameter("username").failureHandler(failureHandler).successHandler(successHandler).permitAll();
        httpSecurity.csrf().disable();

        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(bankService);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);
        return httpSecurity.build();
        }
}
