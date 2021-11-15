package com.vehiclemanagement.vehiclemanagement.configuration;

import com.vehiclemanagement.vehiclemanagement.handler.SecurityEntryPointHandler;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${app.security.user-name}")
      private String username;

    @Value("${app.security.password-text}")
    private String passwordText;

    @Value("${app.security.security-role}")
    private String role;

      @Autowired
       private SecurityEntryPointHandler authenticationEntryPoint;

      @Bean
      public BCryptPasswordEncoder bCryptPasswordEncoder(){
          return  new BCryptPasswordEncoder();

      }
      @Override
     protected  void configure(HttpSecurity httpSecurity) throws Exception{
          httpSecurity.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic()
                  .authenticationEntryPoint(authenticationEntryPoint);
      }
      @Override
    public void configure(AuthenticationManagerBuilder auth) throws  Exception {
          auth.inMemoryAuthentication().withUser(username).password(passwordText).roles(role);
      }


}
