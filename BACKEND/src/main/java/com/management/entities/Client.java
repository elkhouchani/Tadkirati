package com.management.entities;

import jakarta.persistence.*;
import lombok.*;


@Data @NoArgsConstructor @AllArgsConstructor @Entity @Getter @Builder
public class Client extends BaseEntity{
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;

    @OneToOne
    private User user;
}
