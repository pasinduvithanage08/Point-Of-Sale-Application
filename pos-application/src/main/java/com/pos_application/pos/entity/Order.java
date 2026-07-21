package com.pos_application.pos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name="active_state",columnDefinition = "TINYINT default 0")
    private boolean active;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> ordersDetails;

    public Order (Customer customer, Date date,Double total) {
        this.customer = customer;
        this.orderDate = date;
        this.total = total;
    }
}
