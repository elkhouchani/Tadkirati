package com.management.entities;

import com.management.enums.PaymentMethodType;
import com.management.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseEntity{
    private String reference;
    private Double amount;

    @Enumerated
    private PaymentMethodType providerType;

    @Enumerated
    private PaymentStatus status;
}
