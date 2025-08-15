package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.inventry.exposed.InventoryDto;
import com.tazz.modulith.demo.inventry.exposed.InventoryService;
import com.tazz.modulith.demo.order.dto.InventoryRequestDto;
import com.tazz.modulith.demo.order.dto.OrderDto;
import com.tazz.modulith.demo.order.dto.OrderPaymentDto;
import com.tazz.modulith.demo.order.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public record OrderService(InventoryService inventoryService,
                           OrderRepository orderRepository,
                           OrderEventService orderEventService
) {

    public OrderResponseDto createOrder(OrderDto orderDto) {
        // get inventory by name
        List<InventoryDto> inventories = inventoryService.fetchAllWithNames(
                orderDto.inventoryRequestDtoList().stream()
                        .map(InventoryRequestDto::inventoryName).toList());
        // persist the order
        var order = persistOrder(orderDto);
        final AtomicLong amount = new AtomicLong();
        buildAndPersistOrderInventories(orderDto, inventories, order.getId(), amount);

        orderEventService.completeOrder(new OrderPaymentDto(order.getIdentifier(), amount.get()));

        return new OrderResponseDto("Order under process", 102);
    }

    private void buildAndPersistOrderInventories(OrderDto orderDto, List<InventoryDto> inventoryDtos,
                                               long orderId, AtomicLong amount) {
        List<OrderInventory> orderInventories = new ArrayList<>();

        inventoryDtos.forEach(dto -> {
            OrderInventory orderInventory = new OrderInventory();

            Optional<InventoryRequestDto> inventoryRequestDto =
                    orderDto.inventoryRequestDtoList().stream()
                            .filter(inv -> inv.inventoryName().equals(dto.name()))
                            .findFirst();

            if (inventoryRequestDto.isPresent()) {
                InventoryRequestDto invDto = inventoryRequestDto.get();
                orderInventory.setInventoryId(orderId);
                orderInventory.setQuantity(invDto.quantity());
                var totalPrice = dto.price() * invDto.quantity();
                orderInventory.setTotalQuantityPrice(totalPrice);

                orderInventories.add(orderInventory);
                amount.addAndGet(totalPrice);
            }
        });


    }

    private Order persistOrder(OrderDto dto) {
        var order = OrderUtils.mapDtoToOrder(dto);
        orderRepository.save(order);
        return order;
    }
}
