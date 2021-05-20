package com.alkemy.api.repositories;
import java.util.ArrayList;
import com.alkemy.api.models.MovieModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieModel,Integer>{

    public abstract MovieModel getByTitle(String title);

    @Query(value = "SELECT * FROM movies ORDER BY creation_date ASC",nativeQuery = true)
    public ArrayList<MovieModel> getAllByOrderASC();

    @Query(value = "SELECT * FROM movies ORDER BY creation_date DESC",nativeQuery = true)
    public ArrayList<MovieModel> getAllByOrderDESC();
    
}
