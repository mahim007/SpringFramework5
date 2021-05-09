package com.mahim.jokesapp.controller;

import com.mahim.jokesapp.service.JokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private JokesService jokesService;

    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping("/get-jokes")
    public String getJokes(Model model) {
        String jokes = jokesService.getJokes();
        model.addAttribute("jokes", jokes);
        return "jokes";
    }
}
