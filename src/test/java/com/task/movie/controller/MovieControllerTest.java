
package com.task.movie.controller;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.movie.config.Utils;
import com.task.movie.controller.MovieController;
import com.task.movie.model.Movie;
import com.task.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieController.class, secure = false)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @MockBean
    private Utils utils;

    @Test
    public void testCreateNewMovie() throws Exception {
        Movie mockMovie = new Movie("Black Swan", "Surrealist", 5.0);
        String mockMovieJson = this.mapToJson(mockMovie);
        String URI = "/api/v1/movies";
        Mockito.when(movieService.save(Mockito.any(Movie.class))).thenReturn(mockMovie);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(mockMovieJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
        assertThat(outputInJson).isEqualTo(mockMovieJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetMovie() throws Exception {
        Movie mockMovie = new Movie("Black Swan", "Surrealist", 5.0);
        String mockMovieJson = this.mapToJson(mockMovie);
        String URI = "/api/v1/movies/1";
        Mockito.when(movieService.find(Mockito.anyInt())).thenReturn(mockMovie);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON).content(mockMovieJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
        assertThat(outputInJson).isEqualTo(mockMovieJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetAllMovies() throws Exception {
        Movie mockMovie1 = new Movie("Black Swan", "Surrealist", 5.0);
        Movie mockMovie2 = new Movie("Bird Man", "Drama", 4.6);
        Movie mockMovie3 = new Movie("Her", "Sci-fi", 4.1);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(mockMovie1);
        movieList.add(mockMovie2);
        movieList.add(mockMovie3);
        Mockito.when(movieService.findAll()).thenReturn(movieList);
        String URI = "/api/v1/movies";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String mockMoviesJson = this.mapToJson(movieList);
        String outputInJson = response.getContentAsString();
        assertThat(outputInJson).isEqualTo(mockMoviesJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
