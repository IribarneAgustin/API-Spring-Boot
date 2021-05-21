package com.alkemy.api.controllers;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.alkemy.api.models.GenreModel;
import com.alkemy.api.services.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/genres")
@RestController
public class GenreController {

    @Autowired
    private GenreService service;

    @PostMapping("save")
    public GenreModel save(@RequestParam("file") MultipartFile image, @ModelAttribute GenreModel genre){
        
        if(!image.isEmpty()){

            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();     
            try {
                byte[] bytes = image.getBytes();
                Path route = Paths.get(absolutPath + image.getOriginalFilename());
                Files.write(route, bytes);
                genre.setImage(image.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }          

        }
        
        return service.save(genre); 
    }

    
}
