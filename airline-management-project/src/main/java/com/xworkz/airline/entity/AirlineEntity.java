package com.xworkz.airline.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


   @Setter
   @Getter
    @ToString
    @Entity
    @Table(name = "airline_info")
    public class AirlineEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "airline_id")
        private int airlineId;


        @Column(name = "airline_name")
        private String airlineName;


        @Column(name = "country")
        private String country;


        @Column(name = "fleet_size")
        private int fleetSize;
    }