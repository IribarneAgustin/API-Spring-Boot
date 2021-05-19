package com.alkemy.api.repositories;
import java.util.ArrayList;
import com.alkemy.api.models.CharacterModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterModel,Integer>{
    
    public abstract CharacterModel getByName(String name);
    public abstract CharacterModel getByAge(Integer age);
    public abstract CharacterModel getByWeight(Double weight);
    

    @Query(value = "SELECT name,image FROM characters",nativeQuery = true)
    public ArrayList<Object[]> getAll();
    
}
