package demo.requestApi.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "cars")
@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_name")
    private String carName;
}
