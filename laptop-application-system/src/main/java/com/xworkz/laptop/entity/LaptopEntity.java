package com.xworkz.laptop.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

    @Setter
    @Getter
    @ToString
    @Entity
    @Table(name = "laptop_info")
    public class LaptopEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int Id;

        @Column(name = "company")
        private String company;

        @Column(name = "brand")
        private String brand;

        @Column(name = "price")
        private double price;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "processor")
        private String processor;
    }
