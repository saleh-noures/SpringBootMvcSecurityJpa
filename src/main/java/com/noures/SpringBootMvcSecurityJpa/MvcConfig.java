package com.noures.SpringBootMvcSecurityJpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
/*Adapter classes are used in a case when you want to maintain
the default Spring boot configurations, at the same time you
need to make some modifications to these configurations*/
public class MvcConfig extends WebMvcConfigurerAdapter {
/*   If a request handler method returns only the logical view name, then it
    is no use to create the method and the view controller can be registered here instead.*/
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/company").setViewName("company");
        registry.addViewController("/login").setViewName("login");

        //registry.addViewController("/unauthorized").setViewName("unauthorized");
    }

}
