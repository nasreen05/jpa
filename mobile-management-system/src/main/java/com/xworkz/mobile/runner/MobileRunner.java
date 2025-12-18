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


//        MobileService service = new MobileServiceImpl();
//        String result = service.validateAndSave(entity);
//        System.out.println("Result: " + result);

        MobileService mobileService = new MobileServiceImpl();
        boolean response = mobileService.validateAndUpdatePriceQuantityMfdById(51000, 120, "2025-06-06", 2);
        if (response) {
            System.out.println("update successfull");
        } else {
            System.out.println("update failed");
        }

        MobileEntity entity1 = new MobileEntity();

        entity1.setMobileId(4);
        entity1.setName("oppo");
        entity1.setBrand("V10");
        entity1.setPrice(36000);
        entity1.setQuantity(200);
        entity1.setMfd("2023-01-01");

        MobileService mobileService1 = new MobileServiceImpl();
        MobileEntity result = mobileService1.validateAllDetailsById(entity1);
        System.out.println(result);
    }
}