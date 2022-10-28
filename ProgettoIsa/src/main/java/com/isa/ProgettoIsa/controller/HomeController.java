package com.isa.ProgettoIsa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isa.ProgettoIsa.service.LinkService;
import com.isa.ProgettoIsa.model.*;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

  @Autowired
    private LinkService linkService;

    @RequestMapping("/login.html")
    public String login() {
      return "login.html";
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @RequestMapping("/link.html")
    public String link(Model model) {
        model.addAttribute("listLink", true);
        return "link.html";
    }

    @RequestMapping(value="/link",method=RequestMethod.GET)
    public ModelAndView link(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("link");
        mav.addObject("Listalink", linkService.getAllLinks());
        mav.addObject("link", new Link());
        return mav;
    }

/*
    @RequestMapping("/link.html")
    public String link(Model model) {
      return "link.html";
    }
    */

    
}