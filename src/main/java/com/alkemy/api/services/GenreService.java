package com.alkemy.api.services;
import java.util.ArrayList;
import java.util.Optional;

import com.alkemy.api.models.GenreModel;
import com.alkemy.api.models.MovieModel;
import com.alkemy.api.repositories.GenreRepository;
import com.alkemy.api.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MovieRepository movieRepository;


    
    public GenreModel save(GenreModel genre){
        return genreRepository.save(genre);       
    }

    public ArrayList<MovieModel> getMoviesByGenreId(Integer genreId){

        GenreModel genre = genreRepository.getById(genreId);
        ArrayList<MovieModel> movies = new ArrayList<>();

        if(genre != null){
            
        ArrayList<Integer> moviesId = genre.getMoviesId();   

        for (Integer movieId : moviesId) {
            MovieModel movie = movieRepository.getById(movieId);
            movies.add(movie);                        
        }
    }
        
        return movies;
    }
    

    

}
