package com.task.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Ahmed Basuny on 22_04_2020
 * custom error for for handling not found exception
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(Integer id) {
		super("Movie with Id ("+ id +") not found. ");
	}
}
