package com.tazz.modulith.demo.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface OrderInventoryRepository extends JpaRepository<OrderInventory, Long> {

    // named parameters
    @Query("select sum(oi.totalQuantityPrice) from OrderInventory oi where oi.orderId = :orderId")
    long orderPrice(@Param("orderId") long orderId);
}
