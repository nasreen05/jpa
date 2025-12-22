package com.xworkz.powerBank.service;

import com.xworkz.powerBank.entity.PowerBankEntity;

public interface PowerBankService {
    boolean validateAndSavePowerBankInfo(PowerBankEntity entity);
    boolean validateAndUpdatePriceQuantityById(int powerbank_id, int capacity, String brand, double price);
    String  validateAndUpdateAllDetailsById(PowerBankEntity entity);
     boolean validateDeleteById(int powerbank_id);
    PowerBankEntity validateAndFindLaptopById(int powerbank_id);


}
