package com.tazz.modulith.demo.inventry.exposed;

import com.tazz.modulith.demo.inventry.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByName(String name);

    List<Inventory> findByNameIn(List<String> names);
}
