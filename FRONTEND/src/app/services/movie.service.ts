import { Injectable } from '@angular/core';
import {MovieModel} from "../models/movie.model";
import {CategoryModel} from "../models/category.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {apiURL} from "../config";
import {AuthService} from "./auth.service";
import {ShowModel} from "../models/show.model";

const httpOptions = {
  headers : new HttpHeaders({
    'content-Type' : 'application/json'
  })

} ;

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  jwt = "Bearer "+ this.authService.getToken();
  httHeaders = new HttpHeaders({"Authorization":this.jwt})
  movies : MovieModel[];
  movie! : MovieModel;
  shows! : ShowModel[];
  show! : ShowModel;
  constructor( private http : HttpClient,private authService : AuthService){
    this.shows = []
    this.movies = [];
  }
  moviesList(){
    return this.http.get<MovieModel[]>(apiURL+"/movies", {headers:this.httHeaders});
  }
  addMovie(newMovie : MovieModel){
    return this.http.post<MovieModel>(apiURL+"/movies/save",newMovie,{headers:this.httHeaders});
  }
  deleteMovie(id : number){
    return this.http.delete(apiURL+"/movies/"+id,{headers:this.httHeaders});
  }
  editMovie(id:number){
    return this.http.get<MovieModel>(apiURL+"/movies/"+id,{headers:this.httHeaders});
  }
  updateMovie(movie : MovieModel){
    return this.http.put<MovieModel>(apiURL+"/movies/update",movie,{headers:this.httHeaders});
  }


  showsList(){
    return this.http.get<CategoryModel[]>(apiURL+"/shows",{headers:this.httHeaders});

  }

  // editShow(id:number){
  //   this.show = this.shows.find(e=>e.showId == id,{headers:this.httHeaders})!;
  //   return this.show;
  // }
}
