package com.sefaz.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sefaz.controller.LoginController;

public class LoginFilter implements Filter {
	
	@Inject
	private LoginController loginController;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
	 	HttpServletRequest req = (HttpServletRequest) request;
	 	HttpServletResponse res = (HttpServletResponse) response;
	 	
	 	String url = req.getRequestURL().toString();
	 	String uri = req.getRequestURI().toString();
	 	
	 	if(url.contains("/restrito") && !loginController.estaLogado()) {
	 		res.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
	 	}
	 	else {
	 		chain.doFilter(request, response);
	 	}

	}

	@Override
	public void destroy() {
		
	}
	
}
