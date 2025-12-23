package com.xworkz.mobile.runner;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.service.MobileService;
import com.xworkz.mobile.service.MobileServiceImpl;

import java.util.List;

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
//        boolean response = mobileService.validateAndUpdatePriceQuantityMfdById(51000, 120, "2025-06-06", 3);
//        if (response) {
//            System.out.println("update successfull");
//        } else {
//            System.out.println("update failed");
//        }

//        MobileEntity entity1 = new MobileEntity();
//
//        entity1.setMobileId(4);
//        entity1.setName("oppo");
//        entity1.setBrand("V10");
//        entity1.setPrice(36000);
//        entity1.setQuantity(200);
//        entity1.setMfd("2023-01-01");
//
//        MobileService mobileService1 = new MobileServiceImpl();
//        MobileEntity result = mobileService1.validateAllDetailsById(entity1);
//        System.out.println(result);
//
//
//        MobileService mobileService2 = new MobileServiceImpl();
//        boolean deleteResponse = mobileService2.validateDeleteById(4);
//        if (deleteResponse) {
//            System.out.println("deleted successfully");
//        } else {
//            System.out.println("delete failed");
//        }
        // MobileEntity fetch = mobileService.ValidateAndFindMobileEntityById(3);
        // System.out.println(fetch);
      /*  List<MobileEntity> ref =
                mobileService.validateAndGetMobileEntityByBrandAndPrice("V10", 36000);

        System.out.println("ref " + ref);*/


   /* List<MobileEntity> entities = mobileService.findByName("oppo");
        System.out.println("Runner "+entities);*/

        List<MobileEntity> byNameAndBrandAndPriceAndQuantity = mobileService.findByNameAndBrandAndPriceAndQuantity("Redmi Note 12","Xiaomi", 19999, 25);

        System.out.println(byNameAndBrandAndPriceAndQuantity);


    }

    }

    