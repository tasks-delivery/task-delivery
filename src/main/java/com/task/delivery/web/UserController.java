package com.task.delivery.web;

import com.task.delivery.exception.WrongIdFormatException;
import com.task.delivery.model.User;
<<<<<<< HEAD
import com.task.delivery.service.SecurityService;
import com.task.delivery.service.UserService;
import com.task.delivery.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
=======
import com.task.delivery.service.security.SecurityService;
import com.task.delivery.service.user.UserService;
import com.task.delivery.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "resources/templates/signup/registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "resources/templates/signup/registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) throws WrongIdFormatException {
        if (error != null)
<<<<<<< HEAD

            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
    //        throw new WrongIdFormatException();
=======
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
            model.addAttribute("message", "You have been logged out successfully.");

        return "resources/templates/signup/login";

     }
<<<<<<< HEAD

/*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") User userForm, Model model,  BindingResult bindingResult, String error) {
        if (error == null)
            model.addAttribute("error", "Your username and password is invalid.");
        return "redirect:/dashboard";
    }*/

=======
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
}




<<<<<<< HEAD
/*
            if (logout != null) {
                return "redirect:/dashboard";
            }
            return "resources/templates/signup/login";
        }*/





=======
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5


