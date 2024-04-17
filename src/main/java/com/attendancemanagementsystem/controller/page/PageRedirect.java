package com.attendancemanagementsystem.controller.page;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageRedirect {
    @RequestMapping({"", "/"})
    public String indexPage(){
        return "index";
    }

    @RequestMapping("userSignUp")
    public String userSignUpPage(){
        return "signup";
    }

    @RequestMapping("userSignIn")
    public String userSignInPage(){
        return "signin";
    }

    @RequestMapping("welcomePage")
    public String welcomePage(){
        return "welcome";
    }

}
