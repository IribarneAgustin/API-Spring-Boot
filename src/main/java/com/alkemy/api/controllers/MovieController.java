package com.alkemy.api.controllers;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import com.alkemy.api.models.MovieModel;
import com.alkemy.api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping()
    public ArrayList<MovieModel> getAll(){
        return service.getAll();
    }  

    @GetMapping("/details/{id}")
    public Optional<MovieModel> getById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @GetMapping(value = "", params="name")
    public MovieModel getByTitle(@RequestParam("name") String title){
        return service.getByTitle(title);
    }

    @GetMapping(value = "", params="order")
    public ArrayList<MovieModel> getByOrder(@RequestParam("order") String order){
        return service.getByOrder(order);
    }

    // El método save sirve tanto para agregar un nuevo registro como para modificarlo
    @PostMapping("save")
    public MovieModel save(@RequestParam("file") MultipartFile image, @ModelAttribute MovieModel movie){
        
        if(!image.isEmpty()){

            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();     
            try {
                byte[] bytes = image.getBytes();
                Path route = Paths.get(absolutPath + image.getOriginalFilename());
                Files.write(route, bytes);
                movie.setImage(image.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }          

        }
        
        return service.save(movie); 
    }


    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        boolean delete = service.delete(id);
        if(delete){
            return "Se eleminó la película con el id " + id;
        }
        else{
            return "No se pudo eleminar la película con el id " + id;
        }
    }

    


    
}
