package com.xworkz.shopping.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Setter
@Getter
@ToString
@Entity
@Table(name = "mall_info")
public class ShoppingMall {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mall_id")
    private int mallId;


    @Column(name = "mall_name")
    private String mallName;


    @Column(name = "location")
    private String location;


    @Column(name = "shops_count")
    private int shopsCount;
}