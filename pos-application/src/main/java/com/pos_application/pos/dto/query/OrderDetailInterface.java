package com.pos_application.pos.dto.query;

import java.util.ArrayList;
import java.util.Date;


public interface OrderDetailInterface {
    String getCustomerName();
    String getCustomerAddress();
    ArrayList<Integer> getContactNo();
    Date getOrderDate();
    double getTotal();

}
