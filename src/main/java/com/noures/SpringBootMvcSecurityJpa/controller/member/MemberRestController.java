package com.noures.SpringBootMvcSecurityJpa.controller.member;

import com.noures.SpringBootMvcSecurityJpa.domain.Member;
import com.noures.SpringBootMvcSecurityJpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rest/members")
public class MemberRestController {
    @Autowired
    private MemberRepository memberRepository;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Member lookupMemberById(@PathVariable("id") Long id) {
        return memberRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Member> listAllMembers() {
        return memberRepository.findAllOrderByName();
    }
    
    
   @RequestMapping(value = "/{id}.xml", method = RequestMethod.GET, produces = "application/xml")
   public @ResponseBody
   Member lookupMemberByIdAsXml(@PathVariable("id") Long id) {
       return memberRepository.findOne(id);
   }
}


/*
 * Spring 4.0 introduced @RestController, a specialized version of the controller which is a convenience annotation that does nothing more than add the @Controller and @ResponseBody annotations.
 * By annotating the controller class with @RestController annotation, you no longer need to add @ResponseBody to all the request mapping methods. The @ResponseBody annotation is active by default. 
 */

/*
 * The @ResponseBody annotation tells Spring MVC not to render a model into a view, but rather to write the returned object into the response body. 
 * It does this by using one of Spring’s message converters. Because Jackson 2 is in the classpath, this means that MappingJackson2HttpMessageConverter 
 * will handle the conversion of members to JSON if the request’s Accept header specifies that JSON should be returned.
*/
