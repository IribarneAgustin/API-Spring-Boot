package com.alkemy.api.controllers;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import com.alkemy.api.models.MovieModel;
import com.alkemy.api.services.MovieService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.CoreMatchers.*;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MovieControllerTest {

    @TestConfiguration
    static class MovieServiceImplTestContextConfiguration {
        @Bean
        public MovieService movieService() {
            return new MovieService() {
            };
        }
    }

    @Autowired
    private MovieService movieService;

    // Método para agregar un registro en la base de datos
    private void addData() {

        ArrayList<Integer> charactersId = new ArrayList<>();
        charactersId.add(1);
        charactersId.add(2);
        MovieModel movie = new MovieModel();
        Date date = new Date();
        movie.setTitle("example");
        movie.setCreationDate(date);
        movie.setCalification(5);
        movie.setImage("image.jpg");
        movie.setCharactersId(charactersId);
        movieService.save(movie);

    }

    @Test
    @Order(1)
    public void testDelete() {
        addData();
        Boolean response = movieService.delete(1);
        assertTrue(response == true);
    }

    @Test
    @Order(2)
    public void testGetById() {
        addData();
        MovieModel movie = movieService.getById(2).orElse(null);
        assertTrue(movie != null);
    }

    @Test
    @Order(3)
    public void testGetAll() {
        addData();
        ArrayList<Object[]> movies = movieService.getAll();
        assertThat(movies.size(), equalTo(1));
    }

    @Test
    @Order(4)
    public void testGetByTitle() {
        addData();
        MovieModel movie = movieService.getByTitle("example");
        assertTrue(movie != null);
    }

    @Test
    @Order(5)
    public void testGetByOrderASC() {
        addData();
        ArrayList<MovieModel> movies = movieService.getByOrder("ASC");
        assertTrue(movies != null);
    }

    @Test
    @Order(6)
    public void testGetByOrderDESC() {
        addData();
        ArrayList<MovieModel> movies = movieService.getByOrder("DESC");
        assertTrue(movies != null);
    }

    @Test
    @Order(7)
    public void testAddMovie() throws Exception {

        ArrayList<Integer> charactersId = new ArrayList<>();
        charactersId.add(1);
        charactersId.add(2);
        MovieModel movie = new MovieModel();
        Date date = new Date();
        movie.setTitle("example");
        movie.setCreationDate(date);
        movie.setCalification(5);
        movie.setImage("image.jpg");
        movie.setCharactersId(charactersId);
        MovieModel movieSaved = movieService.save(movie);

        assertTrue(movieSaved != null);
    }

    @Test
    @Order(8)
    public void testUpdateMovie() throws Exception {

        //Agregamos un nuevo registro
        addData();
        MovieModel movie = new MovieModel();

        //Lo traemos
        Optional<MovieModel> movieToUpdate = movieService.getById(8);
        movie = movieToUpdate.get();

        //Lo modificamos
        ArrayList<Integer> charactersId = new ArrayList<>();
        charactersId.add(1);
        charactersId.add(2);
        Date date = new Date();
        movie.setId(8);
        movie.setTitle("example");
        movie.setCreationDate(date);
        movie.setCalification(5);
        movie.setImage("image.jpg");
        movie.setCharactersId(charactersId);

        //Lo guardamos
        MovieModel movieSaved = movieService.save(movie);

        //Comprobamos que se haya modificado correctamente
        assertThat(movieSaved.getTitle(), equalTo("example"));
        assertThat(movieSaved.getCreationDate(), equalTo(date));
        assertThat(movieSaved.getCalification(), equalTo(5));
        assertThat(movieSaved.getImage(), equalTo("image.jpg"));
        assertThat(movieSaved.getCharactersId(), equalTo(charactersId));
        assertThat(movieSaved.getId(), equalTo(8));
    }

}
