package com.alkemy.api.models;
import java.util.Date;
import java.util.ArrayList;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "movies")
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String image;
    private String title;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date creationDate;
    private Integer calification;
    private ArrayList<Integer> charactersId = new ArrayList<>();
    


    public MovieModel() {
    }

    public MovieModel(Integer id, String image, String title, Date creationDate, Integer calification, ArrayList<Integer> charactersId) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.creationDate = creationDate;
        this.calification = calification;
        this.charactersId = charactersId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public Integer getCalification() {
        return this.calification;
    }

    public void setCalification(Integer calification) {
        this.calification = calification;
    }

    public ArrayList<Integer> getCharactersId() {
        return this.charactersId;
    }

    public void setCharactersId(ArrayList<Integer> charactersId) {
        this.charactersId = charactersId;
    }

    public MovieModel id(Integer id) {
        setId(id);
        return this;
    }

    public MovieModel image(String image) {
        setImage(image);
        return this;
    }

    public MovieModel title(String title) {
        setTitle(title);
        return this;
    }

    public MovieModel creationDate(Date creationDate) {
        setCreationDate(creationDate);
        return this;
    }

    public MovieModel calification(Integer calification) {
        setCalification(calification);
        return this;
    }

    public MovieModel charactersId(ArrayList<Integer> charactersId) {
        setCharactersId(charactersId);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", image='" + getImage() + "'" +
            ", title='" + getTitle() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", calification='" + getCalification() + "'" +
            ", charactersId='" + getCharactersId() + "'" +
            "}";
    }
  
    
}
