package com.example.be.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JWTEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(JWTEntryPoint.class);


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {
        logger.error("Unauthorized error Message: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Sai tên đăng nhập hoặc mật khẩu");
    }
}
