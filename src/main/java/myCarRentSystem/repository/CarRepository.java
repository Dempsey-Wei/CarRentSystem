package myCarRentSystem.repository;

import myCarRentSystem.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query(value = "SELECT * FROM users order by rand() limit 1", nativeQuery = true)
    Car findRandom();


}
