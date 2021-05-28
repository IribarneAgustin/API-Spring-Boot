package com.alkemy.api.services;
import java.util.ArrayList;
import com.alkemy.api.models.MovieModel;
import com.alkemy.api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public ArrayList<Object[]> getAll(){
        return movieRepository.getAll();
    }
    public Optional<MovieModel> getById(Integer id){
        return movieRepository.findById(id);
    }
    public MovieModel save(MovieModel movie)
    {
        return movieRepository.save(movie);
    }
    public MovieModel getByTitle(String title){
        return movieRepository.getByTitle(title);
    }
    public ArrayList<MovieModel> getByOrder(String order){

        if(order.equals("ASC")){
            return (ArrayList<MovieModel>) movieRepository.getAllByOrderASC();            
        }else if(order.equals("DESC")){
            return (ArrayList<MovieModel>) movieRepository.getAllByOrderDESC();  
        }else{
            return (ArrayList<MovieModel>) movieRepository.findAll();
        }
    }

    public boolean delete(Integer id){
        try{
            movieRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }


    
}
