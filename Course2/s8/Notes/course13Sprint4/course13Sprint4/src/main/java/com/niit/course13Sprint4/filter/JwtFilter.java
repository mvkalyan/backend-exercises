package com.niit.course13Sprint4.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String authHeader=request.getHeader("authorization");

        System.out.println( "Authheader "+authHeader);
        System.out.println( "method "+request.getMethod());
        if("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);
        }else if(authHeader==null || !authHeader.startsWith("Bearer") ){
            throw new ServletException("Missing or Invalid Exception");

        }
        //if authheader found with proper bearer token
        String token=authHeader.substring(7);
        System.out.println( "token "+token);
        Claims claims= Jwts.parser().setSigningKey("mysecuritykey").parseClaimsJws(token).getBody();
        System.out.println("claims in filter "+claims);
        request.setAttribute("claims",claims);
        filterChain.doFilter(request,response);


    }
}
