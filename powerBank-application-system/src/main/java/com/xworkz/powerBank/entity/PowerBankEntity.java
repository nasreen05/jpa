package com.xworkz.powerBank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

    @Setter
    @Getter
    @ToString
    @Entity
    @Table(name = "powerbank_info")
    public class PowerBankEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "powerbank_id")
        private int powerbankId;

        @Column(name = "capacity")
        private int capacity;

        @Column(name = "brand")
        private String brand;

        @Column(name = "price")
        private double price;
    }

