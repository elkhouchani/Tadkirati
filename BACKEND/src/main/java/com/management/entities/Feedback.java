package com.management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback extends BaseEntity{
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long IdFeedback;

    @NotNull
    private String Comment ;

    @NotNull
    private String Rating;



    @ManyToOne
    private Event Event;


    public void setEvent(Event Event) {
        this.Event = Event;
    }
}
