package com.softusing.jiaokaibo.controller;

import com.softusing.jiaokaibo.domain.User;
import com.softusing.jiaokaibo.service.UserService;
import com.softusing.jiaokaibo.form.UserForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result) {
        if (!userForm.confirmPassword()) {
            result.rejectValue("cPassword", "password not ok", "confirmError");
        }
        if (result.hasErrors()) {
            return "register";
        }
        User user = userForm.covnvertToUser();
        userService.save(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginPage(Model model) {

        model.addAttribute("user", new User());
        return "login";

    }
    @PostMapping("/login")
    public String loginPage(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User userLogin = new User();
        userLogin.setUsername(username);
        userLogin.setPassword(password);
        boolean flag = userService.login(userLogin);
        if (flag == true) {
            return "success";

        } else {
            return "error";
        }
    }
    @GetMapping("/com/softusing/jiaokaibo/exception")
    public String testException() {
        throw new RuntimeException();
    }
}
