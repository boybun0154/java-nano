package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.dto.LoginForm;
import com.udacity.jwdnd.course1.cloudstorage.dto.SignupForm;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean login(LoginForm loginForm) {
        return true;
    }

    public boolean signup(SignupForm signupForm) {
        return true;
    }
}
