package com.tazz.modulith.demo.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByIdentifier(String identifier);
}
