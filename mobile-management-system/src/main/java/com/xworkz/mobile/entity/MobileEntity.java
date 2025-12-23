package com.xworkz.mobile.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "mobile_info")

@NamedQuery(
        name = "findAllMobileEntities",
        query = "SELECT m FROM MobileEntity m"
)

@NamedQuery(
        name = "getMobileEntityByMfdAndPriceAndQuantity",
        query = "SELECT m FROM MobileEntity m WHERE m.mfd = :mfd AND m.price = :price AND m.quantity = :quantity"
)
/*@NamedQuery(name = "getBrandAndPrice",
        query = "select m from MobileEntity m where m.brand=:brand and m.price =:price ")*/

@NamedQuery(name = "getBrandAndPrice",
        query = " select m from MobileEntity m where m.brand=: brand and m.price=:price")

@NamedQuery(name="getNameAndBrandAndPriceAndQuantity",
        query  = "SELECT m FROM MobileEntity m WHERE m.name= :name  and m.brand = :brand and m.price = :price  and m.quantity = :quantity ")

@NamedQuery(name = "findByName",
        query = "select m from MobileEntity m where m.name=: name")
public class MobileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mobile_id")
    private int mobileId;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "mfd")
    private String mfd;

    // getters and setters
}