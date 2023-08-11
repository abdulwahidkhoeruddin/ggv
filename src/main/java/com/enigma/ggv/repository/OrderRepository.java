package com.enigma.ggv.repository;

import com.enigma.ggv.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    @Query(value = "SELECT t.* FROM t_order t", nativeQuery = true)
    List<Order> findAll();

}
