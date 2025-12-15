package com.xworkz.hotel.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Setter
@Getter
@ToString
@Entity
@Table(name = "hotel_info")
public class HotelEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int hotelId;


    @Column(name = "hotel_name")
    private String hotelName;


    @Column(name = "rating")
    private int rating;


    @Column(name = "city")
    private String city;
}