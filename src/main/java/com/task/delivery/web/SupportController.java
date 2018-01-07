package com.task.delivery.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SupportController {


    @RequestMapping(value = {"/support"}, method = RequestMethod.GET)
    public String support(Model model) {
        return "resources/templates/navbar/support/support";
    }


}
