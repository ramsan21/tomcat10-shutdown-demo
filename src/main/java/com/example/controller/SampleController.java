package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
    
    @GetMapping("/")
    @ResponseBody
    public String home() {
        logger.info("Home endpoint accessed");
        return "Tomcat 10 Shutdown Demo Application is running!";
    }
}
