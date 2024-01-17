import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventsListComponent } from './events-list/events-list.component';
import { AddEventComponent } from './add-event/add-event.component';
import { EditEventComponent } from './edit-event/edit-event.component';
import {LoginComponent} from "./login/login.component";
import {ForbiddenComponent} from "./forbidden/forbidden.component";
import {eventGuard} from "./event.guard";
import {MoviesListComponent} from "./movies-list/movies-list.component";
import {EditMovieComponent} from "./edit-movie/edit-movie.component";
import {TicketListComponent} from "./ticket-list/ticket-list.component";



const routes: Routes = [
  {path : "events-list", component : EventsListComponent},
  {path : "add-event", component : AddEventComponent,canActivate : [eventGuard]},
  {path : "edit-event/:id", component : EditEventComponent},
  {path : "edit-movie/:id", component : EditMovieComponent},
  {path : "login", component : LoginComponent},
  {path : "forbidden", component : ForbiddenComponent},
  {path : "movies-list", component : MoviesListComponent},

  {path : "ticket-list", component: TicketListComponent},
  // {path: "edit-ticket", component: EditTicketComponent},

  {path : "", redirectTo : "events-list", pathMatch:"full"},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
