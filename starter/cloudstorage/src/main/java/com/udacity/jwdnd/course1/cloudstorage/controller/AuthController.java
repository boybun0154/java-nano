package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.dto.LoginForm;
import com.udacity.jwdnd.course1.cloudstorage.dto.SignupForm;
import com.udacity.jwdnd.course1.cloudstorage.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String getLogin(@ModelAttribute("loginForm") LoginForm loginForm, Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String signupSuccess) {
        if (signupSuccess != null) {
            model.addAttribute("signupSuccess", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        if (authService.login(loginForm)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }

    @GetMapping("/signup")
    public String getSignup(@ModelAttribute("signupForm") SignupForm signupForm, Model model) {
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute("signupForm") SignupForm signupForm, Model model) {
        if (authService.signup(signupForm)) {
            model.addAttribute("success", true);
            return "redirect:/login?signupSuccess";
        } else {
            model.addAttribute("errMsg", "Signup failed. Please try again.");
            return "signup";
        }
    }

    @PostMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("logout", true);
        return "redirect:/login";
    }
}
