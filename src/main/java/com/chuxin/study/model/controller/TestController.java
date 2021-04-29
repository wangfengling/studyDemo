package com.chuxin.study.model.controller;



import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/printHello")
    public String printHellp(@Param("body") String body){
        System.out.println(body);
        return "hello world";
    }
}
