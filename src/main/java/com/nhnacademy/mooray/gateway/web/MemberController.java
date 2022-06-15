package com.nhnacademy.mooray.gateway.web;

import com.nhnacademy.mooray.gateway.dto.account.MemberJoinRequest;
import com.nhnacademy.mooray.gateway.dto.account.MemberLoginRequest;
import com.nhnacademy.mooray.gateway.service.account.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String goSignUpForm() {
        return "auth/sign-up-form";
    }

    @PostMapping("/signup")
    public ModelAndView doSignUp(@Valid @ModelAttribute MemberJoinRequest memberJoinRequest,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("auth/sign-up-form");
        }

        ModelAndView mav = new ModelAndView("redirect:/login");

        String response = memberService.signUp(memberJoinRequest);
        mav.addObject("response", response);

        return mav;
    }

    @GetMapping("/login")
    public String goLoginForm() {
        return "auth/sign-in-form";
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@Valid @ModelAttribute MemberLoginRequest memberRequest,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("auth/sign-in-form");
        }

        ModelAndView mav = new ModelAndView("redirect:/login");

        String response = memberService.login(memberRequest);
        mav.addObject("response", response);

        return mav;
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/index";
    }

}
