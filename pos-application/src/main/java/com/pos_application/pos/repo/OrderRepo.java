package com.pos_application.pos.repo;

import com.pos_application.pos.dto.query.OrderDetailInterface;
import com.pos_application.pos.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "select  c.customer_name as customerName,c.customer_address as customerAddress,c.contact_numbers as " +
            "contactNo,o.order_date as orderDate,o.total as total from " + "customer c,orders o where o.active_state = ?1 and c.customer_id = o.customer_id", nativeQuery = true)
    List<OrderDetailInterface> getAllOrderDetails(boolean status, Pageable pageable);
}
