package com.haseong.demo.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class SecurityFilter implements Filter {

  private static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    logger.info("init filter");

    HttpServletResponse response = (HttpServletResponse) servletResponse;
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE");
    response.setHeader("Access-Control-MAX-AGE", "3600");
    response.setHeader("Access-Control-ALLOW-HEADERS","x-member-id");


    filterChain.doFilter(servletRequest, servletResponse);
  }


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }


  @Override
  public void destroy() {

  }
}
