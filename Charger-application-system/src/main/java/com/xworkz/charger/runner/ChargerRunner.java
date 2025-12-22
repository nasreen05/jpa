package com.xworkz.charger.runner;

import com.xworkz.charger.entity.ChargerEntity;

import com.xworkz.charger.service.ChargerService;
import com.xworkz.charger.service.ChargerServiceImpl;

public class ChargerRunner {
    public static void main(String[] args) {



        ChargerEntity charger = new ChargerEntity();
        charger.setBrand("MI");
        charger.setPower(33);
        charger.setPrice(999.0);



        ChargerEntity charger1 = new ChargerEntity();
        ChargerService chargerService= new ChargerServiceImpl();

        boolean deleted = chargerService.validateDeleteById(1);
        if (deleted) {
            System.out.println("delete successful");
        } else {
            System.out.println("delete failed");
        }

        ChargerEntity fetch = chargerService.validateAndFindMobileEntityById(2);
        System.out.println(fetch);
    }
}