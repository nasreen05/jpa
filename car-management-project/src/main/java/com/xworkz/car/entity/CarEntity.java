package com.xworkz.car.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Setter
@Getter
@ToString
@Entity
@Table(name = "car_info")
public class CarEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;


    @Column(name = "brand")
    private String brand;


    @Column(name = "model")
    private String model;


    @Column(name = "price")
    private int price;
}