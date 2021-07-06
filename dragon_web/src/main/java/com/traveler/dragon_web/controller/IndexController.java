package com.traveler.dragon_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(Model model) {

        model.addAttribute("index","ahaha");

        return ResultUtil.view("index");
    }
}
