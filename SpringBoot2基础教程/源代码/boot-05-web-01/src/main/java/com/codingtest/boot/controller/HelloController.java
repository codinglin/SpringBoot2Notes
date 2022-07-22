package com.codingtest.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/001_im.png")
    public String hello(){
        return "abc";
    }

    // @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping(value = "/user")
    public String getUser(){
        return "GET-张三";
    }

    // @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping(value = "/user")
    public String saveUser(){
        return "POST-张三";
    }


    // @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping(value = "/user")
    public String putUser(){
        return "PUT-张三";
    }

    // @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping(value = "/user")
    public String deleteUser(){
        return "DELETE-张三";
    }
}
