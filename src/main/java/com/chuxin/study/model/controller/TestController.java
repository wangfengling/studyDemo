package com.chuxin.study.model.controller;



import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/printHello")
    public String printHellp(@Param("body") String body){
        log.info(body);
        return "hello world";
    }
}
