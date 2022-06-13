package com.nhnacademy.mooray.gateway.web;

import com.nhnacademy.mooray.gateway.dto.MemberJoinRequest;
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

    // FIXME: index 페이지
    @GetMapping("/")
    public String goSignUpForm() {
        return "members/form";
    }

    @PostMapping("/signup")
    public ModelAndView doSignUp(@Valid @ModelAttribute MemberJoinRequest memberJoinRequest,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("members/sign-up-form");
        }

        ModelAndView mav = new ModelAndView("redirect:/auth/login");

        String response = memberService.signUp(memberJoinRequest);
        mav.addObject("response", response);

        return mav;
    }

}
