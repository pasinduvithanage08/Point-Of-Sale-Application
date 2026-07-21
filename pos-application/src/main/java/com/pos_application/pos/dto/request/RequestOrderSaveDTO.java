package com.pos_application.pos.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customer;
    private Date orderDate;
    private List<RequesetOrderDetailsSave> ordersDetails;
    private double total;
    private boolean active;


}
