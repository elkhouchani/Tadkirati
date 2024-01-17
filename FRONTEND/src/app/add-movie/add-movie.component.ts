import { Component } from '@angular/core';
import { MovieModel } from "../models/movie.model";
import { MovieService } from "../services/movie.service";
import { ShowModel } from "../models/show.model";
import { Router } from "@angular/router";

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent {
  newMovie = new MovieModel();
  shows!: ShowModel[];

  constructor(private movieService: MovieService, private router: Router) {
    // Assuming you have a method to get the list of shows from the service
    movieService.showsList().subscribe(s=>{
      // this.shows = s ;
    })
  }

  addMovie() {
    // Assuming you have a method to add a movie in the service
    this.movieService.addMovie(this.newMovie).subscribe(() => {
      this.router.navigate(['movies-list']);
    });
  }
}
