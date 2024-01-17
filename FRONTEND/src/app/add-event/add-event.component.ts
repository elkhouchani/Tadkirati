import { Component } from '@angular/core';
import {EventModel} from "../models/event.model";
import {EventService} from "../services/event.service";
import {CategoryModel} from "../models/category.model";
import {Router} from "@angular/router";


@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent {
  newEvent = new EventModel();
  categories! : CategoryModel[];
  newCategory! : CategoryModel;
  newCategoryId! : number;
  constructor(private eventService : EventService , private router : Router){
    eventService.categoriesList().subscribe(c=>{
      this.categories = c ;
    })
   // this.categories = eventService.categoriesList();
  }
  addEvent(){
      this.newEvent.category = this.categories.find(c=>c.idCategory == this.newCategoryId);
      this.eventService.addEvent(this.newEvent).subscribe(p=>{
        this.router.navigate(['events-list'])
      })

    }
}
