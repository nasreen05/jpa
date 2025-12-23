package com.xworkz.medicine.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

    @Setter
    @Getter
    @ToString
    @Entity
    @Table(name = "medicine_info")
    @NamedQuery(name = "findAllMedicineEntities", query = "SELECT m FROM MedicineEntity m")
    public class MedicineEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "medicine_id")
        private int medicineId;

        @Column(name = "name")
        private String name;

        @Column(name = "manufacturer")
        private String manufacturer;

        @Column(name = "price")
        private double price;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "expiry_date")
        private String expiryDate;
    }

