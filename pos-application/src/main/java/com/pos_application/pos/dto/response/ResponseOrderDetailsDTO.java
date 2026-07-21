package com.pos_application.pos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
        private String customerName;
        private String customerAddress;
        private ArrayList<Integer> contactNo;   // back to ArrayList<Integer>
        private Date orderDate;
        private double total;

}
