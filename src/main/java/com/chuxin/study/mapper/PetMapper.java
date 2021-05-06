package com.chuxin.study.mapper;

import com.chuxin.study.model.Pet;

public interface PetMapper {

    Pet queryPetByName(String name);

}
