package com.attendancemanagementsystem.controller;

import com.attendancemanagementsystem.controller.page.PageRedirect;
import com.attendancemanagementsystem.entity.User;
import com.attendancemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("users/")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PageRedirect redirect;


    /*
    *
    * User Signup
    *
    * */


    @PostMapping({"signUp"})
    public String addNewUser(User newUser){
        if(userService.addNewUser(newUser)){
            return "index";
        }
        return redirect.userSignUpPage();
    }

    /*
    *
    * User Login
    *
    * */
    @PostMapping({"user-login","admin-login","faculty-login","student-login"})
    public String userLogin(User user, Model model){
        User userLogin = userService.userLogin(user);
        if(userLogin==null){
            //Invalid user email id
            return redirect.userSignInPage();
        } else if (userLogin.getUserPassword().equals(user.getUserPassword())) {
            //correct password entered


            //admin dashboard
            if (userLogin.getUserRole().equalsIgnoreCase("admin")) {
                model.addAttribute("adminName",userLogin.getUserFullName());
                return redirect.adminDashboard(model);
            }
            //faculty dashboard
            else if (userLogin.getUserRole().equalsIgnoreCase("faculty"))
                return redirect.adminDashboard(model);
            //student dashboard
            else
                return redirect.studentDashboard(model);
        }else {
            //wrong password entered
            return redirect.userSignInPage();
        }
    }

    /*
    *
    * Delete User
    *
    * */
    @GetMapping("delete")
    public String deleteUser(Long userId){
        return userService.deleteUser(userId) ? "":"";
    }

    /*
    *
    * Update User
    *
    * */
    @PostMapping("update")
    public String updateUser(Long userId, User updateUser){
        User userData = userService.updateExistingUser(userId, updateUser);
        return "";
    }

    /*
    *
    * Get User By Id
    *
    * */
    @GetMapping("id")
    public String getUserById(Long userId){
        User userData = userService.getUserById(userId);
        return "";
    }

    /*
    *
    * List of User By Name
    *
    * */
    @GetMapping("userList")
    public String getUserByName(String name){
        List<User> userList = userService.getUserByName(name);

        return "";
    }

    /*
    *
    * List of User by Role
    *
    * */
    @GetMapping("listByRole")
    public String getUserByRole(String role){
        List<User> userList = userService.getUserByRole(role);
        return "";
    }


}
