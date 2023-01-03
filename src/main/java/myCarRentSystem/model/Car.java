package myCarRentSystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "used_count")
    private Integer usedCount;

    @Column(name = "status")
    private String status;

}
