package com.pos_application.pos.entity;


import com.pos_application.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="item")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 255,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="measure_type",length = 255,nullable = false)
    private MeasuringUnitType measureType;


    @Column(name="balance_qty",length = 255,nullable = false)
    private double balanceQty;

    @Column(name="supplier_price",length = 255,nullable = false)
    private double supplierPrice;

    @Column(name="selling_price",length = 255,nullable = false)
    private double sellingPrice;

    @Column(name="active_state",columnDefinition = "TINYINT default 0")
    private boolean active;

    @OneToMany(mappedBy = "item")
    private Set<OrderDetails> ordersDetails;









    }



