import {CategoryModel} from "./category.model";

export class EventModel{
  eventId? : number;
  eventName? : string;
  eventDate? : Date;
  eventDescription? : string;
  eventVenue? : string;
  category? : CategoryModel;
}
