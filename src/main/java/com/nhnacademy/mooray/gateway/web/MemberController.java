package com.nhnacademy.mooray.gateway.web;

import com.nhnacademy.mooray.gateway.dto.MemberSignUpRequest;
import com.nhnacademy.mooray.gateway.service.MemberService;
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
    public ModelAndView doSignUp(@Valid @ModelAttribute MemberSignUpRequest memberRequest,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("auth/sign-up-form");
        }

        ModelAndView mav = new ModelAndView("redirect:/auth/login");

        String response = memberService.signUp(memberRequest);
        mav.addObject("response", response);

        return mav;
    }

    @GetMapping("/auth/login")
    public String goLoginForm() {
        return "auth/sign-in-form";
    }

    @GetMapping("/members/logout")
    public String goLogout() {
        return "auth/logout";
    }

}
