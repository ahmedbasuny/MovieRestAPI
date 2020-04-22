package com.task.movie;

import com.task.movie.model.Movie;
import com.task.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MovieApplication implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Movie[] movies = {
                new Movie("Black Swan", "Surrealist", 5.0),
                new Movie("Bird Man", "Drama", 4.6),
                new Movie("Her", "Sci-fi", 4.1),
                new Movie("La La Land", "romance", 3.8),
                new Movie("Life of pi", " Adventure", 2.9)};
        Arrays.asList(movies).forEach(movie -> movieService.save(movie));
    }
}
