package hibernate.dltepayee.secure;

import hibernate.dltepayee.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class PaymentSecurity {

    @Autowired
    PaymentService paymentService;
//    @Autowired
//    HttpSecurity httpSecurity;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails userDetails1= User.withDefaultPasswordEncoder().username("Apoorva").password("pass").roles("head").build();
//        UserDetails userDetails2= User.withDefaultPasswordEncoder().username("Karthi").password("fail").roles("manager").build();
//        List<UserDetails> userDetailsList= Stream.of(userDetails1,userDetails2).collect(Collectors.toList());
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }
//
//    @Bean
//    public RoleHierarchy roleHierarchy(){
//        //String roleRule="admin>manager\nmanager>developers";
//        String roleRule="head>manager";
//        RoleHierarchyImpl roleHierarchy=new RoleHierarchyImpl();
//        roleHierarchy.setHierarchy(roleRule);
//        return roleHierarchy;
//    }
//
//    @Bean
//    public DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler(){
//        DefaultWebSecurityExpressionHandler web=new DefaultWebSecurityExpressionHandler();
//        web.setRoleHierarchy(roleHierarchy());
//        return web;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
        httpSecurity.formLogin();

//        httpSecurity.authorizeRequests().expressionHandler(defaultWebSecurityExpressionHandler()).
//                antMatchers(HttpMethod.GET,"/roleHierarchy").hasRole("manager");
//
//        httpSecurity.authorizeRequests().antMatchers(HttpMethod.PUT).hasRole("head");
//        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST).hasRole("head");
//        httpSecurity.authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("head").anyRequest().authenticated();

        return httpSecurity.build();
    }

}
