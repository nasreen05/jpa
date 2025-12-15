package com.xworkz.restaurant.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

    @Entity
    @Table(name = "Restaurant_info")
    @Getter
    @Setter
    @ToString
    public class RestaurantEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Restaurant_id")
        private int restaurantId;

        @Column(name = "name")
        private String name;

        @Column(name = "location")
        private String location;

        @Column(name = "rating")
        private float rating;
    }

