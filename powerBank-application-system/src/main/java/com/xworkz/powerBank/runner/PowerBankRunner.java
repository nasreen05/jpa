package com.xworkz.powerBank.runner;


import com.xworkz.powerBank.entity.PowerBankEntity;
import com.xworkz.powerBank.service.PowerBankService;
import com.xworkz.powerBank.service.PowerBankServiceImpl;

class PowerBankRunner{

public static void main(String[] args) {

    PowerBankEntity entity = new PowerBankEntity();
    entity.setCapacity(1000000);
    entity.setBrand("Dell");
    entity.setPrice(65000);


    PowerBankService powerBankService = new PowerBankServiceImpl();


    boolean deleted = powerBankService.validateDeleteById(1);

    if (deleted) {
        System.out.println("Delete successful");
    } else {
        System.out.println("Delete failed");
    }


    PowerBankEntity fetch = powerBankService.validateAndFindLaptopById(1);
    System.out.println(fetch);
}
}
