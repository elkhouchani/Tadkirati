package com.management.entities;

import com.management.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Booking extends BaseEntity{
    @ManyToOne
    private Client client;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private Date bookedAt;

    @Enumerated
    private BookingStatus status;

    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}
