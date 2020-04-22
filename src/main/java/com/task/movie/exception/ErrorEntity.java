package com.task.movie.exception;

/**
 * @author Ahmed Basuny on 22_04_2020
 * handle custom error
 */
public class ErrorEntity {
    String error;

    public ErrorEntity(String error) {
        this.error = error;
    }

    public ErrorEntity() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
