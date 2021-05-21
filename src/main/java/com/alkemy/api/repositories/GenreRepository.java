package com.alkemy.api.repositories;
import java.util.ArrayList;
import com.alkemy.api.models.GenreModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends CrudRepository<GenreModel,Integer> {
    
    @Query(value = "SELECT movies_id FROM genres WHERE id = :genreId ",nativeQuery = true)
    public ArrayList<Integer> getMoviesIdByGenre(@Param("genreId") Integer genreId);

    
    public abstract GenreModel getById(Integer genreId);


        
}
