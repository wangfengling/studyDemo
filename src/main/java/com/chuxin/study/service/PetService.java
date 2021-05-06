package com.chuxin.study.service;

import com.chuxin.study.mapper.PetMapper;
import com.chuxin.study.model.Pet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PetService {

    @Resource
    private PetMapper petMapper;

    public Pet queryPetByName(String name) {
        return petMapper.queryPetByName(name);
    }

}
