package com.pos_application.pos.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name= "orders_details")

public class OrderDetails {
    @Id
    @Column(name="order_details_id" ,length=45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;

    @Column(name = "item_name",length = 255,nullable = false)
    private String itemName;

    @Column(name="qty",length = 255,nullable = false)
    private double qty;

    @Column(name="amount",nullable=false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name="item_id",nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name="order_id",nullable = false)
    private Order orders;
}
