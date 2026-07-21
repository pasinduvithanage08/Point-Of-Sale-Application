package com.pos_application.pos.dto.request;


import com.pos_application.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ItemSaveRequestDTO {

    private String itemName;
    private MeasuringUnitType measureType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;


}
