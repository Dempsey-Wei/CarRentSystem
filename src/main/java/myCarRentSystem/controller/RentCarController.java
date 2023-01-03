package myCarRentSystem.controller;

import myCarRentSystem.model.User;
import myCarRentSystem.service.CarService;
import myCarRentSystem.service.OrderService;
import myCarRentSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/v1")
public class RentCarController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "registerForm";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/api/v1/queryUsers";
    }

    @GetMapping("/queryUsers")
    public String queryUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "userList";
    }

    @GetMapping("/queryCars")
    public String queryCars(Model model) {
        model.addAttribute("listCars", carService.getAllCars());
        return "carsList";
    }

    @GetMapping("/rentCarForm/{carId}")
    public String rentCarForm(@PathVariable(value = "carId") long carId, Model model) {
        model.addAttribute("carId", carId);
        return "rentForm";
    }

    @PostMapping("/rent")
    public String rent(@ModelAttribute("userId") long userId, @ModelAttribute("carId") long carId, Model model) {
        long orderId = carService.rent(userId, carId);
        if (orderId > 0) {
            model.addAttribute("result", "rent successful");
            model.addAttribute("orderId", orderId);
        } else {
            model.addAttribute("result", "rent failed");
        }
        return "rentResult";
    }

    @GetMapping("/returnCarForm")
    public String returnCarForm() {
        return "returnCarForm";
    }

    @PostMapping("/returnCar")
    public String returnCar(@ModelAttribute("orderId") long orderId, Model model) {
        long res = carService.returnCar(orderId);
        if (res > 0) {
            model.addAttribute("result", "return car successful");
        } else {
            model.addAttribute("result", "return car failed");
        }
        return "returnCarResult";
    }

    @GetMapping("/queryOrders")
    public String queryOrders(Model model) {
        model.addAttribute("listOrders", orderService.getAllOrders());
        return "orderList";
    }

}
