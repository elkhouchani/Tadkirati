package com.management.services;

import com.management.entities.Movie;
import com.management.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Movie Not found: "+id));
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieById(Long id, Movie updatedMovie) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Movie Not found: " + id));

        // Update the properties with data from the updated movie
        existingMovie.setName(updatedMovie.getName());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setLanguages(updatedMovie.getLanguages());
        existingMovie.setFeatures(updatedMovie.getFeatures());
        // Update other properties as needed

        // Save the updated movie
        return movieRepository.save(existingMovie);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}
