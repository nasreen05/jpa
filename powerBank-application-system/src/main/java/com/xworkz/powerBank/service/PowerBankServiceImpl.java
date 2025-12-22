package com.xworkz.powerBank.service;

import com.xworkz.powerBank.entity.PowerBankEntity;
import com.xworkz.powerBank.repository.PowerBankRepository;
import com.xworkz.powerBank.repository.PowerBankRepositoryImpl;

public class PowerBankServiceImpl  implements  PowerBankService{
PowerBankRepository repository = new PowerBankRepositoryImpl();

    @Override
    public boolean validateAndSavePowerBankInfo(PowerBankEntity entity) {
        System.out.println("Invoking validateANdSave in ServiceImpl");
        boolean isValid = false;
        if (entity != null) {
            isValid = repository.savePowerBankInfo(entity);
        } else {
            isValid = false;
        }
        return isValid;
    }

    @Override
    public boolean validateAndUpdatePriceQuantityById(int powerbank_id, int capacity, String brand, double price) {
       System.out.println("Invoking validateAndUpdatePriceQuantityMfnById");
    boolean isValid = false;

    if (price > 0.0d && capacity> 0 && brand != null && !brand.isEmpty() && powerbank_id > 0) {
        isValid = repository.updateBandCategoryQuantityById(capacity, brand, price, powerbank_id);


        System.out.println("Process successful");
    } else {
        System.out.println("Process failed");
        isValid = false;
    }
    return isValid;
}

    @Override
public String validateAndUpdateAllDetailsById(PowerBankEntity entity) {
    System.out.println("Invoking validation");
    String isValidated = null;
    if (entity != null) {
        isValidated = repository.updateAllDetailsById(entity);
    } else {
        System.out.println("VAlidation failed ");
    }
    return isValidated;
}

@Override
//   public  boolean validateAndDeleteById(int id) {
public boolean validateDeleteById(int powerbank_id) {
    System.out.println("Invoking Validation");
    boolean isDeleted = false;
    if (powerbank_id > 0) {
        isDeleted = repository.deleteById(powerbank_id);
    } else {
        isDeleted = false;
    }
    return isDeleted;
}

@Override
public PowerBankEntity validateAndFindLaptopById(int powerbank_id) {
    System.out.println("Invoking validation");
    PowerBankEntity validFetch = null;

    if (powerbank_id > 0) {
        validFetch = repository.findPowerBankEntityById(powerbank_id);
    }
    return validFetch;
}


}
