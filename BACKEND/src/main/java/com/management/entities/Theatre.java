package com.management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String name;
    private String address;

    @OneToMany
    private List<Hall> halls = new ArrayList<>();

    @OneToMany
    private List<Show> shows = new ArrayList<>();
}
