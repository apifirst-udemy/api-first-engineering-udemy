package com.rsouza01.apifirst_server.domain;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "char(36)", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    // @NotNull
    private Order order;

    @ManyToOne
    @NotNull
    private Product product;

    @NotNull
    @Min(1)
    @Max(10000)
    private Integer orderQuantity;

    @NotNull
    @Min(1)
    @Max(10000)
    private Integer shipQuantity;
}