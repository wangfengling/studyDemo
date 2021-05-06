package com.chuxin.study.mapper;

import com.chuxin.study.WebControllerTest;
import com.chuxin.study.model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

@Slf4j
public class PetMapperTest extends WebControllerTest {
    @Resource
    private PetMapper petMapper;

   @Test
    public void testPet(){
        Pet dog = petMapper.queryPetByName("dog");
        log.info("this result:{}", dog.getOwner());
    }
}
