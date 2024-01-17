package com.management.restcontrollers;

import com.management.entities.Movie;
import com.management.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/movies/save")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/movies/update")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @PutMapping("/movies/update/{id}")
    public Movie updateMovieById(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        return movieService.updateMovieById(id, updatedMovie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovieById(@PathVariable("movieId") Long movieId) {
        movieService.deleteMovieById(movieId);
    }
}
