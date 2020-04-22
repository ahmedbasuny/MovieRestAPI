package com.task.movie.controller;

import com.task.movie.config.Utils;
import com.task.movie.model.Movie;
import com.task.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ahmed Basuny on 22_04_2020
 * endpoints for movie crud operations
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    Utils utils;

    @PostMapping("/movies")
    private ResponseEntity<?> createNewMovie(@RequestBody Movie movie) {
        try {
            return new ResponseEntity<>(movieService.save(movie), HttpStatus.OK);
        } catch (Exception e) {
            return utils.returnError(e);
        }
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies() {
        try {
            return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return utils.returnError(e);
        }
    }

    @GetMapping("/movies/{id}")
    private ResponseEntity<?> getMovie(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(movieService.find(id), HttpStatus.OK);
        } catch (Exception e) {
            return utils.returnError(e);
        }
    }

    @PutMapping("/movies/{id}")
    ResponseEntity<?> updateMovie(@RequestBody Movie newMovie, @PathVariable Integer id) {
        try {
            Movie updatedMovie = movieService.find(id);
            updatedMovie.setMovieTitle(newMovie.getMovieTitle());
            updatedMovie.setMovieCategory(newMovie.getMovieCategory());
            updatedMovie.setMovieRate(newMovie.getMovieRate());
            return new ResponseEntity<>(movieService.save(updatedMovie), HttpStatus.OK);
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
