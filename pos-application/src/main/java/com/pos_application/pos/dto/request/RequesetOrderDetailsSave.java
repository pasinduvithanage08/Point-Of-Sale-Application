package com.pos_application.pos.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequesetOrderDetailsSave {
    private String itemName;
    private double qty;
    private Double amount;
    private int item;
    private int orders;
}
