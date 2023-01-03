package myCarRentSystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
@Data
public class RentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createTime")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endTime")
    private Date endTime;

    @Column(name = "carId")
    private long carId;

    @Column(name = "userId")
    private long userId;

    @Column(name = "status")
    private String status;

}
