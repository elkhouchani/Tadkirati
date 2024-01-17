import { Component, OnInit } from '@angular/core';
import {EventModel} from "../models/event.model";
import {EventService} from "../services/event.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CategoryModel} from "../models/category.model";




@Component({
  selector: 'app-edit-event',
  templateUrl: './edit-event.component.html',
  styleUrls: ['./edit-event.component.css']
})
export class EditEventComponent implements OnInit{
  currentEvent = new EventModel();
  categories! : CategoryModel[];
  newCategory! : CategoryModel;
  newCategoryId! : number;
  constructor(
  private eventService : EventService,
  private activatedRoute : ActivatedRoute,
  private router : Router
  ){   // this.categories = this.eventService.categoriesList();
  }
  ngOnInit(){
    this.eventService.categoriesList().subscribe(c=>{
      this.categories = c ;
    })
    this.eventService.editEvent(this.activatedRoute.snapshot.params['id']).subscribe(p=>
    {
      this.currentEvent = p;
      this.newCategoryId =this.currentEvent.category?.idCategory!;
    })
  }

  updateEvent(){
    this.currentEvent.category = this.categories.find(c=>c.idCategory==this.newCategoryId)
    this.eventService.updateEvent(this.currentEvent).subscribe(p=>{
      this.router.navigate(['events-list']);
    })

  }
}
