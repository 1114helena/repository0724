package com.haseong.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  private static final String[] EXCLUDE_PATHS = {
      "/members/**",
      "/webjars/**",
      "/swagger-resources/**",
      "/csrf/**",
      "/swagger-ui.html",
      "/error/**",
      "/downloadFile/**"
  };

  @Autowired
  private JwtInterceptor jwtInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(jwtInterceptor)
//        .addPathPatterns("/**")
        .excludePathPatterns(EXCLUDE_PATHS);
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "HEAD");
  }
}