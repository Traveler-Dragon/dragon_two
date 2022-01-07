package com.traveler.server.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author DELL
 */
@RestController
@RequestMapping("/only")
public class OnlyController {

    @GetMapping("/add")
    public void add(HttpSession session){

    }
}
