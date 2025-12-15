package com.xworkz.bike.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Setter
@Getter
@ToString
@Entity
@Table(name = "bike_info")
public class BikeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bike_id")
    private int bikeId;


    @Column(name = "brand")
    private String brand;


    @Column(name = "model")
    private String model;


    @Column(name = "price")
    private int price;
}
