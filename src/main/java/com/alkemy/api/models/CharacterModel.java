package com.alkemy.api.models;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class CharacterModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String name;
    private String image;
    private Integer age;
    private Double weight;
    private String history;
    private ArrayList<Integer> filmId = new ArrayList<>();


    public CharacterModel() {
    }

    public CharacterModel(Integer id, String name, String image, Integer age, Double weight, String history, ArrayList<Integer> filmId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.filmId = filmId;
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

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return this.history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public ArrayList<Integer> getFilmId() {
        return this.filmId;
    }

    public void setFilmId(ArrayList<Integer> filmId) {
        this.filmId = filmId;
    }

    public CharacterModel id(Integer id) {
        setId(id);
        return this;
    }

    public CharacterModel name(String name) {
        setName(name);
        return this;
    }

    public CharacterModel image(String image) {
        setImage(image);
        return this;
    }

    public CharacterModel age(Integer age) {
        setAge(age);
        return this;
    }

    public CharacterModel weight(Double weight) {
        setWeight(weight);
        return this;
    }

    public CharacterModel history(String history) {
        setHistory(history);
        return this;
    }

    public CharacterModel filmId(ArrayList<Integer> filmId) {
        setFilmId(filmId);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", image='" + getImage() + "'" +
            ", age='" + getAge() + "'" +
            ", weight='" + getWeight() + "'" +
            ", history='" + getHistory() + "'" +
            ", filmId='" + getFilmId() + "'" +
            "}";
    }

}