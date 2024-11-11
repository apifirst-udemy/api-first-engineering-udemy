package com.rsouza01.apifirst_server.domain;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import com.rsouza01.apifirst_server.domain.OrderStatusEnum;

import java.time.OffsetDateTime;
import java.util.ArrayList;
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
@Table(name = "order_header")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "char(36)", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @NotNull
    private Customer customer;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @NotNull
    private OrderStatusEnum orderStatus = OrderStatusEnum.NEW;

    @ManyToOne
    private PaymentMethod selectedPaymentMethod;

    @Size(min=1,max=255)
    private String shipmentInfo;

    @Builder.Default
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @NotNull
    private List<OrderLine> orderLines = new ArrayList<>();

    @CreationTimestamp
    private OffsetDateTime dateCreated;

    @UpdateTimestamp
    private OffsetDateTime dateUpdated;
}