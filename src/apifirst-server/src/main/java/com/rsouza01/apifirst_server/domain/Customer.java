package com.rsouza01.apifirst_server.domain;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Valid
    @Column(length = 36, columnDefinition = "char(36)", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address shipToAddress;

    @NotNull
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address billToAddress;

    @NotNull
    @Valid
    @Embedded
    private Name name;

    @Size(min=3,max=255)
    private String email;

    @Size(min=7,max=15)
    private String phone;

    @Valid
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<PaymentMethod> paymentMethods;

    @PrePersist
    public void prePersist() {
        if (this.paymentMethods != null && !this.paymentMethods.isEmpty()) {
            this.paymentMethods.forEach(paymentMethod -> paymentMethod.setCustomer(this));
        }
    }

    @CreationTimestamp
    private OffsetDateTime dateCreated;

    @UpdateTimestamp
    private OffsetDateTime dateUpdated;
}