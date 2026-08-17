package com.jsp.movies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Movie name cannot be empty")
    @Size(min = 2, max = 100, message = "Movie name should be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Director name cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Director name should contain only alphabets")
    private String director;

    @NotBlank(message = "Hero name cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Hero name should contain only alphabets")
    private String hero;

    @NotBlank(message = "Heroin name cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Heroin name should contain only alphabets")
    private String heroin;

    @Min(value = 1900, message = "Year must be greater than or equal to 1900")
    @Max(value = 2100, message = "Year must be less than or equal to 2100")
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getHeroin() {
        return heroin;
    }

    public void setHeroin(String heroin) {
        this.heroin = heroin;
    }
}