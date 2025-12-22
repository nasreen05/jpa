package com.xworkz.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

    @Getter
    @Setter
    @ToString
    @Entity

    @Table(name = "warehouse_info")
    public class InventoryEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "inventory_id")
        private int id;

        @Column(name = "item_name")
        private String itemName;

        @Column(name = "category")
        private String category;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "warehouse_location")
        private String warehouseLocation;

        @Column(name = "last_update")
        private String lastUpdate;
    }
