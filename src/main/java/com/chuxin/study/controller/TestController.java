package com.chuxin.study.controller;


import com.chuxin.study.model.Pet;
import com.chuxin.study.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestController {

    @Resource
    private PetService petService;

    @GetMapping("/printHello/{name}")
    @ResponseBody
    public Pet printHellp(@PathVariable String name){
        return petService.queryPetByName(name);
    }
}
