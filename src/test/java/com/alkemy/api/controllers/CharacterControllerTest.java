package com.alkemy.api.controllers;
import java.util.ArrayList;
import java.util.Optional;
import com.alkemy.api.models.CharacterModel;
import com.alkemy.api.services.CharacterService;
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
public class CharacterControllerTest {

    @TestConfiguration
    static class CharacterServiceImplTestContextConfiguration {
        @Bean
        public CharacterService characterService() {
            return new CharacterService() {
            };
        }
    }
    
    @Autowired
    private CharacterService characterService;

    // Método para agregar un registro en la base de datos
    private void addData() {

        ArrayList<Integer> filmId = new ArrayList<>();
        CharacterModel character = new CharacterModel();
        filmId.add(1);
        character.setName("example");
        character.setImage("image.jpg");
        character.setAge(50);
        character.setWeight(100.00);
        character.setHistory("history");
        character.setFilmId(filmId);
        characterService.save(character);

    }

    @Test
    @Order(1)
    public void testDelete() {
        addData();
        Boolean response = characterService.delete(1);
        assertTrue(response == true);
    }

    @Test
    @Order(2)
    public void testGetById() {
        addData();
        CharacterModel character = characterService.getById(2).orElse(null);
        assertTrue(character != null);
    }

    @Test
    @Order(3)
    public void testGetAll() {
        addData();
        ArrayList<Object[]> characters = characterService.getAll();
        assertThat(characters.size(), equalTo(1));
    }

    @Test
    @Order(4)
    public void testGetByName() {
        addData();
        CharacterModel character = characterService.getByName("example");
        assertThat(character, notNullValue());
    }

    @Test
    @Order(5)
    public void testGetByAge() {
        addData();
        CharacterModel character = characterService.getByAge(50);
        assertTrue(character != null);
    }

    @Test
    @Order(6)
    public void testGetByWeight() {
        addData();
        CharacterModel character = characterService.getByWeight(100.00);
        assertThat(character, notNullValue());
    }

    @Test
    @Order(7)
    public void testGetByMovieId() {
        addData();
        ArrayList<CharacterModel> characters = characterService.getByMovieId(1);
        assertThat(characters, notNullValue());
    }
    
    @Test
    @Order(8)
    public void testAddCharacter() throws Exception {

        ArrayList<Integer> filmId = new ArrayList<>();
        CharacterModel character = new CharacterModel();
        character.setName("Test");
        character.setImage("image.jpg");
        character.setAge(50);
        character.setWeight(100.00);
        character.setHistory("history");
        character.setFilmId(filmId);

        CharacterModel characterSaved = characterService.save(character);
        assertTrue(characterSaved != null);
    }
    @Test
    @Order(9)
    public void testUpdateCharacter() throws Exception {

        addData();
        ArrayList<Integer> filmId = new ArrayList<>();
        CharacterModel character = new CharacterModel();

        Optional<CharacterModel> movieToUpdate = characterService.getById(9);
        character = movieToUpdate.get();
        
        character.setId(9);
        character.setName("Test");
        character.setImage("image.jpg");
        character.setAge(50);
        character.setWeight(100.00);
        character.setHistory("history");
        character.setFilmId(filmId);

        CharacterModel characterSaved = characterService.save(character);

        assertThat(characterSaved.getId(), equalTo(9));
        assertThat(characterSaved.getName(), equalTo("Test"));
        assertThat(characterSaved.getImage(), equalTo("image.jpg"));
        assertThat(characterSaved.getAge(), equalTo(50));
        assertThat(characterSaved.getWeight(), equalTo(100.00));
        assertThat(characterSaved.getHistory(), equalTo("history"));
        assertThat(characterSaved.getFilmId(), equalTo(filmId));
  
    }



}
