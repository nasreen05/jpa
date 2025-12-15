package com.xworkz.flight.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Flight_info")
@Getter
@Setter
@ToString
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Flight_id")
    private int flightId;

    @Column(name = "flight_name")
    private String flightName;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;
}
