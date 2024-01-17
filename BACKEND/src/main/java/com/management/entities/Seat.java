package com.management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import com.management.enums.SeatType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Seat extends BaseEntity{
    private Integer rowNo;
    private Integer columnNo;
    @Enumerated
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
}
