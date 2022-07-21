package com.codingTest.boot.controller;

import com.codingTest.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController = @Controller + @ResponseBody
 */
@RestController
public class HelloController {
    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String handle01(){
        return "Hello, SpringBoot2";
    }

    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
