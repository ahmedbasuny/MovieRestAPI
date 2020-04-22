package com.task.movie.service;

import java.util.List;

import com.task.movie.exception.MovieNotFoundException;
import com.task.movie.model.Movie;
import com.task.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    public Movie find(Integer id) {
        return movieRepo.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public void delete(Integer id) {
        movieRepo.delete(this.find(id));
    }
}

