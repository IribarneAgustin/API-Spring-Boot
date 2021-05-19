package com.alkemy.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.alkemy.api.models.CharacterModel;
import com.alkemy.api.repositories.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;


    public ArrayList<Object[]> getAll(){
        return characterRepository.getAll();
    }
    public CharacterModel save(CharacterModel character){
        return characterRepository.save(character);

    }
    public CharacterModel getByName(String name){
        return characterRepository.getByName(name);
    }

    public CharacterModel getByAge(Integer age){
        return characterRepository.getByAge(age);
    }
    public CharacterModel getByWeight(Double weight){
        return characterRepository.getByWeight(weight);
    }
    public ArrayList<CharacterModel> getByMovieId(Integer movieId){

        ArrayList<CharacterModel> characters = (ArrayList<CharacterModel>) characterRepository.findAll();
        ArrayList<CharacterModel> toReturn = new ArrayList<>();

        for (CharacterModel character : characters) {
            ArrayList<Integer> movieIds = character.getFilmId();
            if(movieIds.contains(movieId)){
                toReturn.add(character);
            }            
        }
        
        return toReturn;
       
    }
    public boolean delete(Integer id){
        try{
            characterRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }


}
