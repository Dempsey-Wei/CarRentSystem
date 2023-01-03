package myCarRentSystem.service;

import myCarRentSystem.model.RentOrder;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    @Test
    void createOrder() {
        RentOrder order = new RentOrder();
        order.setOrderId(1l);

    }
}