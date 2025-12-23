package com.xworkz.furniture.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

    @Setter
    @Getter
    @ToString
    @Entity
    @Table(name = "furniture_info")
    @NamedQuery(
            name = "findAllFurnitureEntities",
            query = "SELECT f FROM FurnitureEntity f"
    )
    public class FurnitureEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "furniture_id")
        private int furnitureId;

        @Column(name = "name")
        private String name;

        @Column(name = "material")
        private String material;

        @Column(name = "price")
        private double price;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "mfd")
        private String mfd;
    }
