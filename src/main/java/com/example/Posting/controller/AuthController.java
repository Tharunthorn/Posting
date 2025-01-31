package com.example.Posting.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class AuthController {
    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response,
                         Authentication auth) {

        if (auth != null){
            new SecurityContextLogoutHandler()
                    .logout(request, response, auth);
        }

        // You can redirect wherever you want, but generally it's a good
        // practice to show the login screen again.
        return "redirect:/login?logout";
    }
}
