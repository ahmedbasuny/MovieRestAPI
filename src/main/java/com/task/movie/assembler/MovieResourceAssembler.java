package com.task.movie.assembler;

/**
 * @author Ahmed Basuny on 22_04_2020
 * to convert model to resource to achieve hateoas principle
 */

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.task.movie.controller.MovieResourceController;
import com.task.movie.model.Movie;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class MovieResourceAssembler implements ResourceAssembler<Movie, Resource<Movie>>{
	@Override
	public Resource<Movie> toResource(Movie movie) {
		return new Resource<Movie>((movie),
				linkTo(methodOn(MovieResourceController.class).getMovie(movie.getMovieId())).withSelfRel(),
				linkTo(methodOn(MovieResourceController.class).getAllMovies()).withRel("movies"));
	}
}
