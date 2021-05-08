package com.chuxin.study.groovy;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApiProcessConfiguration {

    private FlowGroovyShell flowShell;


    @PostConstruct
    public void initMethod(){
        flowShell = new FlowGroovyShell();

    }


}
