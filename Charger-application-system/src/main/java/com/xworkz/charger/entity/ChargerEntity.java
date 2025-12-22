package com.xworkz.charger.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "charger_info")
public class ChargerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int chargerId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "power")
    private int power;

    @Column(name = "price")
    private double price;


}

