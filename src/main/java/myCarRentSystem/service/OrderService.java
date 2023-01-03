package myCarRentSystem.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import myCarRentSystem.repository.OrderRepository;
import myCarRentSystem.model.RentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderService{

    @Autowired
    private OrderRepository orderRepository;

    public List<RentOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public long createOrder(long usrId, long carId) {
        getAllOrders();
        RentOrder rentOrder = new RentOrder();
        rentOrder.setCreateTime(new Date());
        rentOrder.setCarId(carId);
        rentOrder.setUserId(usrId);
        rentOrder.setStatus("doing");
        savaOrder(rentOrder);
        return rentOrder.getOrderId();
    }

    public void savaOrder(RentOrder rentOrder) {
        orderRepository.save(rentOrder);
    }

    public RentOrder getOrderById(long id) {
        Optional<RentOrder> optional = orderRepository.findById(id);
        RentOrder rentOrder =null;
        if(optional.isPresent()) {
            rentOrder = optional.get();
        }
        return rentOrder;
    }


}


