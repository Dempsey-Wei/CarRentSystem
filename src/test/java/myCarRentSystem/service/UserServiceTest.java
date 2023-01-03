package myCarRentSystem.service;

import myCarRentSystem.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void createUser() {
        User user  = new User(1, "Bob", "Bob@163.com", 123l);
        Assert.assertEquals("Bob@163.com", user.getEmail());
    }
}