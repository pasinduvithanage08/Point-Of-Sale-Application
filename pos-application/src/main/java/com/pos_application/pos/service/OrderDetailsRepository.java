package com.pos_application.pos.service;

import com.pos_application.pos.entity.OrderDetails;
import org.springframework.data.repository.Repository;

interface OrderDetailsRepository extends Repository<OrderDetails, Integer> {
}
