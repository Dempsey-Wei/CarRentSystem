package myCarRentSystem.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import myCarRentSystem.repository.CarRepository;
import myCarRentSystem.model.Car;
import myCarRentSystem.model.RentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CarService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OrderService orderService;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Transactional
    public long rent(long usrId, long carId) {
        // 1. check
        Car car = getCarById(carId);
        if (car == null || !car.getStatus().equals("available")) {
            return -1;
        }

        // 2. deduct
        car.setStatus("occupied");
        saveCar(car);

        // 3. create order
        long orderId = orderService.createOrder(usrId, carId);

        return orderId;
    }

    @Transactional
    public long returnCar(long orderId) {
        // 1. check and modify order
        RentOrder order = orderService.getOrderById(orderId);
        if (order == null || !order.getStatus().equals("doing")) {
            return -1;
        }
        order.setStatus("done");
        order.setEndTime(new Date());
        orderService.savaOrder(order);

        // 2. return car
        Car car = getCarById(order.getCarId());
        car.setStatus("available");
        car.setUsedCount(car.getUsedCount() + 1);
        saveCar(car);

        return orderId;
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public Car getCarById(long id) {
        Optional<Car> optional = carRepository.findById(id);
        Car car =null;
        if(optional.isPresent()) {
            car = optional.get();
        }else {
            throw new RuntimeException("Car not found for id :: " + id);
        }
        return car;
    }

    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }


}


