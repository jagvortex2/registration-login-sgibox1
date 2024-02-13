package com.nyc.sgibo.registrationloginsgibox1.controller;


import jakarta.validation.Valid;
import com.nyc.sgibo.registrationloginsgibox1.dto.UserDto;
import com.nyc.sgibo.registrationloginsgibox1.entity.User;
import com.nyc.sgibo.registrationloginsgibox1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@Controller
public class AuthController {

    private UserService userService;

    //Constructor with args
    public AuthController(UserService userService){
        this.userService = userService;
    }

    //Handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }


    //Handle method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    //Handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        //Create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";

    }


    //Handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
            BindingResult result, Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
          result.rejectValue("email", null,
                  "Ya hay una cuenta registrada con el mismo correo electronico");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
            }



            //Handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }




}
