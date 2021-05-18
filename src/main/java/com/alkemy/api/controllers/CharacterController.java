package com.alkemy.api.controllers;
import java.util.ArrayList;
import java.util.Optional;

import com.alkemy.api.models.CharacterModel;
import com.alkemy.api.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/characters")
@RestController
public class CharacterController {

    @Autowired
    CharacterService service;

    @GetMapping()
    public ArrayList<CharacterModel> getAll(){
        return service.getAll();
    }

    @PostMapping("save")
    public CharacterModel save(@RequestBody CharacterModel character){
        return service.save(character); 
    }

    @GetMapping(value = "", params="name")
    public CharacterModel getByName(@RequestParam("name") String name){
        return service.getByName(name);
    }
    @GetMapping(value = "", params="age")
    public CharacterModel getByAge(@RequestParam("age") Integer age){
        return service.getByAge(age);
    }

    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        boolean delete = service.delete(id);
        if(delete){
            return "Se eleminó el usuario con el id " + id;
        }
        else{
            return "No se pudo eleminar el usuario con el id " + id;
        }
    }

    


    
}
