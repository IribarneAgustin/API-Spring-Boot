package com.alkemy.api.controllers;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import com.alkemy.api.models.CharacterModel;
import com.alkemy.api.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/characters")
@RestController
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping()
    public ArrayList<Object[]> getAll(){
        return service.getAll();
    }

    // El método save sirve tanto para agregar un nuevo registro como para modificarlo
    @PostMapping("save")
    public CharacterModel save(@RequestParam("file") MultipartFile image, @ModelAttribute CharacterModel character){
        
        if(!image.isEmpty()){

            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();     
            try {
                byte[] bytes = image.getBytes();
                Path route = Paths.get(absolutPath + image.getOriginalFilename());
                Files.write(route, bytes);
                character.setImage(image.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }          

        }
        
        return service.save(character); 
    }


    @GetMapping("/details/{id}")
    public Optional<CharacterModel> getById(@PathVariable("id") Integer characterId){
        return service.getById(characterId);
    }

    @GetMapping(params="name")
    public CharacterModel getByName(@RequestParam("name") String name){
        return service.getByName(name);
    }
    @GetMapping(params="age")
    public CharacterModel getByAge(@RequestParam("age") Integer age){
        return service.getByAge(age);
    }
    @GetMapping(params="weight")
    public CharacterModel getByWeight(@RequestParam("weight") Double weight){
        return service.getByWeight(weight);
    }
    @GetMapping(params="idMovie")
    public ArrayList<CharacterModel> getByMovieId(@RequestParam("idMovie") Integer idMovie){
        return service.getByMovieId(idMovie);
    }

    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        boolean delete = service.delete(id);
        if(delete){
            return "Se eleminó el personaje con el id " + id;
        }
        else{
            return "No se pudo eleminar el personaje con el id " + id;
        }
    }

    
}
