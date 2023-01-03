package myCarRentSystem.service;

import myCarRentSystem.model.RentOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

class OrderServiceTest {

    @Test
    void createOrder() {
        RentOrder order = new RentOrder();
        order.setOrderId(1l);
        order.setCreateTime(new Date());
        order.setCarId(2l);
        order.setUserId(3l);
        order.setStatus("doing");

        Assert.assertEquals(1l, order.getOrderId());
        Assert.assertEquals(2l, order.getCarId());
        Assert.assertEquals(3l, order.getUserId());
        Assert.assertEquals("doing", order.getStatus());
    }
}