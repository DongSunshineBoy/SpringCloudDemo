package com.orderservice.orderservice.jpa;


import com.orderservice.orderservice.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {

}
