package com.xworkz.mobile.runner;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.service.MobileService;
import com.xworkz.mobile.service.MobileServiceImpl;

public class MobileRunner {

    public static void main(String[] args) {

        MobileEntity entity = new MobileEntity();
        entity.setName("Galaxy");
        entity.setBrand("Samsung");
        entity.setPrice(50000);
        entity.setQuantity(100);
        entity.setMfd("2023-01-01");

        MobileService service = new MobileServiceImpl();
        String result = service.validateAndSave(entity);

        System.out.println("Result: " + result);
    }
}
