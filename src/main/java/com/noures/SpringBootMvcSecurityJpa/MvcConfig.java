package com.noures.SpringBootMvcSecurityJpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
Adapter classes are used in a case when you want to maintain
the default Spring boot configurations, at the same time you
need to make some modifications to these configurations
*/

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
/*  If a request handler method returns only the logical view name, it
    is no use to create a dedicated request handler method, alternatively
    view controller can be registered and used for this purpose.*/
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/company").setViewName("company");
        registry.addViewController("/login").setViewName("login");

        //registry.addViewController("/unauthorized").setViewName("unauthorized");
    }

    //CORS Support
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**");
    }

}
