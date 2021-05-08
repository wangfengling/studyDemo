package com.chuxin.study.controller;


import com.chuxin.study.groovy.Flow;
import com.chuxin.study.groovy.FlowGroovyShell;
import com.chuxin.study.model.Pet;
import com.chuxin.study.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/testGroovy/{name}")
    @ResponseBody
    public Pet testGroovy(@PathVariable String name){
        ClassPathResource classPathResource = new ClassPathResource("groovy/flow.groovy");
        FlowGroovyShell flowGroovyShell = new FlowGroovyShell();
        try {
            Flow flow = (Flow) flowGroovyShell.evaluate(classPathResource.getFile());
            flow.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Pet();
    }


    public static void main(String[] args){
        List<String> list = null;
        list.stream().distinct().collect(Collectors.toList());
    }
}
