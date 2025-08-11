package com.tazz.modulith.demo.inventry.exposed;

import java.util.List;

public interface InventoryService {

    InventoryDto fetchInventoryByName(String name);

    List<InventoryDto> fetchAllWithNames(List<String>names);
}
