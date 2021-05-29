package com.alkemy.api.controllers;

import java.util.ArrayList;
import java.util.Date;

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
    static class EmployeeServiceImplTestContextConfiguration {
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
        MovieModel movie = movieService.getByTitle("example");
        assertTrue(movie != null);
    }

}
