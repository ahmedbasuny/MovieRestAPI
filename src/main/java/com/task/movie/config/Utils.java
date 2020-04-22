package com.task.movie.config;

import com.task.movie.exception.ErrorEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Ahmed Basuny on 22_04_2020
 * to handle the utils of the project like handling customer error.
 */

@Service
public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public ResponseEntity<?> returnError(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(new ErrorEntity(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
