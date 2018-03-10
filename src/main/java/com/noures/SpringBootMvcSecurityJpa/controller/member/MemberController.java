package com.noures.SpringBootMvcSecurityJpa.controller.member;

import com.noures.SpringBootMvcSecurityJpa.domain.Member;
import com.noures.SpringBootMvcSecurityJpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/member*","/user"})
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String displaySortedMembers(Model model) {
        model.addAttribute("newMember", new Member());
        model.addAttribute("members", memberRepository.findAllOrderByName());
        return "member";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerNewMember(@Valid @ModelAttribute("newMember") Member newMember, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            try {
                memberRepository.save(newMember);
                return "redirect:/member";
            } catch (UnexpectedRollbackException e) {
                model.addAttribute("members", memberRepository.findAllOrderByName());
                model.addAttribute("error", e.getCause().getCause());
                return "member";
            }
        } else {
            model.addAttribute("members", memberRepository.findAllOrderByName());
            return "member";
        }
    }
}
