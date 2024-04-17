package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.controller.page.PageRedirect;
import com.attendancemanagementsystem.entity.User;
import com.attendancemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users/")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PageRedirect redirect;


    @PostMapping("signUp")
    public String addNewUser(User newUser){
        if(userService.addNewUser(newUser)){
            return "Welcome";
        }
        return redirect.userSignUpPage();
    }

    @PostMapping("login")
    public String userLogin(User user){
        User userLogin = userService.userLogin(user);
        if(userLogin==null){
            //Invalid user email id
            return redirect.userSignInPage();
        } else if (userLogin.getUserPassword().equals(user.getUserPassword())) {
            //correct password entered
            return redirect.welcomePage();
        }else {
            //wrong password entered
            return redirect.userSignInPage();
        }
    }

}
