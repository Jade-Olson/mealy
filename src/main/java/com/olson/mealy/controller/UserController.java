package com.olson.mealy.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.olson.mealy.models.User;
import com.olson.mealy.services.UserService;
import com.olson.mealy.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/register") // registration form page
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@PostMapping("/register") // registration post handling
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		} else {
			userService.saveWithUserRole(user);
			return "redirect:/login";
		}
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
	
}
