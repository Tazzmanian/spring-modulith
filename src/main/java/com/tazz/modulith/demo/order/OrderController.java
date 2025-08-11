package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.order.dto.OrderDto;
import com.tazz.modulith.demo.order.dto.OrderResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public record OrderController(OrderService orderService) {

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto dto) {
        return new ResponseEntity<>(orderService.createOrder(dto), HttpStatus.CREATED);
    }
}
