package myCarRentSystem.repository;

import myCarRentSystem.model.RentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<RentOrder,Long> {


}
