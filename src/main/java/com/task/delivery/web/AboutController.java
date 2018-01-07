package com.task.delivery.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String about(Model model) {
        return "resources/templates/navbar/about/about";
    }

}
