package com.alkemy.api.models;
import java.util.ArrayList;
import javax.persistence.*;


@Entity
@Table(name = "genres")
public class GenreModel {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String name;
    private String image;
    private ArrayList<Integer> moviesId = new ArrayList<>();

    public GenreModel() {
    }

    public GenreModel(Integer id, String name, String image, ArrayList<Integer> moviesId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.moviesId = moviesId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Integer> getMoviesId() {
        return this.moviesId;
    }

    public void setMoviesId(ArrayList<Integer> moviesId) {
        this.moviesId = moviesId;
    }

    public GenreModel id(Integer id) {
        setId(id);
        return this;
    }

    public GenreModel name(String name) {
        setName(name);
        return this;
    }

    public GenreModel image(String image) {
        setImage(image);
        return this;
    }

    public GenreModel moviesId(ArrayList<Integer> moviesId) {
        setMoviesId(moviesId);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", image='" + getImage() + "'" +
            ", moviesId='" + getMoviesId() + "'" +
            "}";
    }

}
