package com.nhnacademy.mooray.gateway.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    // FIXME: index 페이지
    @GetMapping("/")
    public String goSignUpForm() {
        return "members/form";
    }

}
