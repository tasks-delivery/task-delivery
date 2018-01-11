package com.task.delivery.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DocsController {

    @RequestMapping(value = {"/docs"}, method = RequestMethod.GET)
    public String docs(Model model) {
        return "resources/templates/common/docs/docs";
    }
}
