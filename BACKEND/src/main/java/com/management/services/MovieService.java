package com.management.services;

import com.management.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> getAllMovies();
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie movie);
    void deleteMovieById(Long id);
    Movie getMovieById(Long id);
    Movie updateMovieById(Long id, Movie updatedMovie);


}
