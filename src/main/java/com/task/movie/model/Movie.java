package com.task.movie.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "movie_title")
    @NotEmpty(message = "Movie title can't be empty.")
    @ApiModelProperty(notes = "Title shouldn't be blank")
    private String movieTitle;

    @Column(name = "movie_category")
    @Size(min = 3, max = 20, message = "Movie Category digits should be between(3, 20) digits.")
    @ApiModelProperty(notes = "Category should be between(3, 20) digits.")
    private String movieCategory;

    @Column(name = "movie_rate")
    @Positive(message = "Movie Rate should be between 0.5 to 5 stars.")
    @ApiModelProperty(notes = "Rate should be between 0.5 to 5 stars.")
    private Double movieRate;

    public Movie() {
    }

    public Movie(String movieTitle, String movieCategory, Double movieRate) {
        this.movieTitle = movieTitle;
        this.movieCategory = movieCategory;
        this.movieRate = movieRate;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public Double getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(Double movieRate) {
        this.movieRate = movieRate;
    }
}
