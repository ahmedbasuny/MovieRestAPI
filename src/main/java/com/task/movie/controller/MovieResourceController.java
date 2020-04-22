package com.task.movie.controller;

import com.task.movie.assembler.MovieResourceAssembler;

import com.task.movie.config.Utils;
import com.task.movie.model.Movie;
import com.task.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Ahmed Basuny on 22_04_2020
 * Movie controller v2 that achieve hateoas principle
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v2")
public class MovieResourceController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieResourceAssembler movieAssembler;

    @Autowired
    Utils utils;

    @PostMapping("/movies")
    private ResponseEntity<?> createNewMovie(@RequestBody Movie movie) {
        try {
            Resource<Movie> movieResource = movieAssembler.toResource(movieService.save(movie));
            return ResponseEntity.created(new URI(movieResource.getId().expand().getHref()))
                    .body(movieResource);
        } catch (Exception e) {
            return utils.returnError(e);
        }
    }

    @GetMapping("/movies")
    public Resources<Resource<Movie>> getAllMovies() {
        List<Resource<Movie>> movies = movieService.findAll().stream()
                .map(movieAssembler::toResource).collect(Collectors.toList());
        return new Resources<>(movies, linkTo(methodOn(MovieResourceController.class).getAllMovies()).withSelfRel());
    }


    @GetMapping("/movies/{id}")
    public Resource<Movie> getMovie(@PathVariable Integer id) {
        return movieAssembler.toResource(movieService.find(id));
    }


    @PutMapping("/movies/{id}")
    ResponseEntity<?> updateMovie(@RequestBody Movie newMovie, @PathVariable Integer id) {
        try {
            Movie updatedMovie = movieService.find(id);
            updatedMovie.setMovieTitle(newMovie.getMovieTitle());
            updatedMovie.setMovieCategory(newMovie.getMovieCategory());
            updatedMovie.setMovieRate(newMovie.getMovieRate());
            Movie movie = movieService.save(updatedMovie);
            Resource<Movie> movieResource = movieAssembler.toResource(movie);
            return ResponseEntity
                    .created(new URI(movieResource.getId().expand().getHref()))
                    .body(movieResource);
        } catch (Exception e) {
            return utils.returnError(e);
        }
    }

    @DeleteMapping("/movies/{id}")
    ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        try {
            movieService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return utils.returnError(e);
        }
    }
}
