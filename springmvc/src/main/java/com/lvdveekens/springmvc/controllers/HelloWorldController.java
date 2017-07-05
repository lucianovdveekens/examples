package com.lvdveekens.springmvc.controllers;

import com.lvdveekens.springmvc.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
    protected ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView model = new ModelAndView("HelloWorldPage");
        String msg = helloWorldService.getMsg();
        model.addObject("msg", msg);
        return model;
    }

}
