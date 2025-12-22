package com.xworkz.laptop.runner;

import com.xworkz.laptop.entity.LaptopEntity;
import com.xworkz.laptop.service.LaptopService;
import com.xworkz.laptop.service.LaptopServiceImpl;

public class LaptopRunner {

    public static void main(String[] args) {

        LaptopEntity entity = new LaptopEntity();
        entity.setCompany("Inspiron");
        entity.setBrand("Dell");
        entity.setPrice(65000);
        entity.setQuantity(20);
        entity.setProcessor("Intel i5");

        LaptopService laptopService = new LaptopServiceImpl();


        boolean deleted = laptopService.validateDeleteById(1);

        if (deleted) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Delete failed");
        }


        LaptopEntity fetch = laptopService.validateAndFindLaptopById(1);
        System.out.println(fetch);
    }
}
