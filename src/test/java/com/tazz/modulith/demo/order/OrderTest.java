package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.TestTestcontainerConfig;
import com.tazz.modulith.demo.order.dto.InventoryRequestDto;
import com.tazz.modulith.demo.order.dto.OrderDto;
import com.tazz.modulith.demo.order.dto.OrderResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@Import(TestTestcontainerConfig.class)
@ActiveProfiles("testcontainers")
@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
class  OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    void verifyModule(){
    }

    @Test
    void createOrder_shouldPersistDataAndSendEvent() {
        OrderDto dto = new OrderDto("testName", "test@abv.bg", List.of(
                new InventoryRequestDto("ruler", 1),
                new InventoryRequestDto("pencil", 3)
        ));

        OrderResponseDto responseDto = orderService.createOrder(dto);

        Assertions.assertEquals("Order under process", responseDto.message());
        Assertions.assertEquals(102, responseDto.statusCode());
    }
}