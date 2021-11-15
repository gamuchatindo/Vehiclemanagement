package com.vehiclemanagement.vehiclemanagement.handler;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SecurityEntryPointHandler extends BasicAuthenticationEntryPoint {


    public void afterProperties() throws Exception{
        setRealmName("sample-application");
        super.afterPropertiesSet();
    }
    public  void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException{
        response.addHeader("www.Authenticate", "Basic realm" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer=response.getWriter();
        writer.println("401-UNATHOURISED");
    }


}
