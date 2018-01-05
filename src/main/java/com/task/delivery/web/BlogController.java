package com.task.delivery.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {

    @RequestMapping(value = {"/blog"}, method = RequestMethod.GET)
    public String blog(Model model) {
        return "blog";
    }
}
