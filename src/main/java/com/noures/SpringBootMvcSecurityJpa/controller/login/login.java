package com.noures.SpringBootMvcSecurityJpa.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class login {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();

        if (error != null) {
            if(error.equalsIgnoreCase("unauthorized")) //THIS VALUE IS SET public class GlobalAccessDeniedHandler implements AccessDeniedHandler {
            {
                model.addObject("error", "OPS! YOU ARE NOT AUTHORISED.");
            }
            else // ELSE CHECK FOR THE EXISTENCE OF "ERROR" PARAM THAT IS SET IN SecurityConfig ".failureUrl("/login?error")"
            {
                model.addObject("error", "Invalid username and password!");
            }

        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }
}
