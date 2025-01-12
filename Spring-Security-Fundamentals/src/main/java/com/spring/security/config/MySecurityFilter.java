package com.spring.security.config;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MySecurityFilter extends GenericFilterBean implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Before");
		chain.doFilter(request, response);
		System.out.println("After");
	}

}
