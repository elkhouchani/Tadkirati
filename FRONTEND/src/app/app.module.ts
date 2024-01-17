import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventsListComponent } from './events-list/events-list.component';
import { AddEventComponent } from './add-event/add-event.component';
import {FormsModule} from "@angular/forms";
import { EditEventComponent } from './edit-event/edit-event.component'
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { MoviesListComponent } from './movies-list/movies-list.component';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { EditMovieComponent } from './edit-movie/edit-movie.component';
import { TicketListComponent } from './ticket-list/ticket-list.component';

@NgModule({
  declarations: [
    AppComponent,
    EventsListComponent,
    AddEventComponent,
    EditEventComponent,
    LoginComponent,
    ForbiddenComponent,
    MoviesListComponent,
    AddMovieComponent,
    EditMovieComponent,
    TicketListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
