import { Component } from '@angular/core';
import {AuthService} from "../services/auth.service";
import {MovieModel} from "../models/movie.model";
import {MovieService} from "../services/movie.service";

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent {

  movies! : MovieModel[];
  constructor(private movieService : MovieService , public authService : AuthService){
    movieService.moviesList().subscribe(p=>{
      // console.log(p);
      this.movies =p ;
    })
    //this.events = eventService.eventsList();
  }
  deleteMovie(movie : MovieModel){
    let message = confirm("Are you sure you want to delete this movie?");
    if(message)
      this.movieService.deleteMovie(movie.Id!).subscribe(()=>{
        this.loadEvents()
      });
  }
  loadEvents(){
    this.movieService.moviesList().subscribe(p=>{
      this.movies = p ;
    })
  }
}
