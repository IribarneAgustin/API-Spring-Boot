package com.alkemy.api.repositories;

import com.alkemy.api.models.CharacterModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterModel,Integer>{
    
    public abstract CharacterModel getByName(String name);
    public abstract CharacterModel getByAge(Integer age);
        
    
    
}
