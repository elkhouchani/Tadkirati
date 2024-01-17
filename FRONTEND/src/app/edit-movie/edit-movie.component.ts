import {Component, OnInit} from '@angular/core';
import {EventModel} from "../models/event.model";
import {CategoryModel} from "../models/category.model";
import {EventService} from "../services/event.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MovieModel} from "../models/movie.model";
import {ShowModel} from "../models/show.model";
import {MovieService} from "../services/movie.service";

@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./edit-movie.component.css']
})
export class EditMovieComponent implements OnInit{
  currentMovie = new MovieModel();
  shows! : ShowModel[];
  newShow! : ShowModel;
  newShowId! : number;
  constructor(
    private movieService : MovieService,
    private activatedRoute : ActivatedRoute,
    private router : Router
  ){   // this.categories = this.eventService.categoriesList();
  }
  ngOnInit(){
    // this.movieService.showsList().subscribe(s=>{
    //   this.shows = s ;
    // })
    this.movieService.editMovie(this.activatedRoute.snapshot.params['id']).subscribe(p=>
    {
      this.currentMovie = p;
      // this.newMovieId =this.currentMovie.category?.idCategory!;
    })
  }

  updateMovie(){
    //this.currentEvent.category = this.categories.find(c=>c.idCategory==this.newCategoryId)
    this.movieService.updateMovie(this.currentMovie).subscribe(p=>{
      this.router.navigate(['movies-list']);
    })

  }
}
