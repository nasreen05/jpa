package com.xworkz.laptop.service;

import com.xworkz.laptop.entity.LaptopEntity;
import com.xworkz.laptop.repository.LaptopRepository;
import com.xworkz.laptop.repository.LaptopRepositoryImpl;

public class LaptopServiceImpl implements  LaptopService {
    LaptopRepository repository = new LaptopRepositoryImpl();

    @Override
    public boolean validateAndSaveLaptopInfo(LaptopEntity entity) {
        System.out.println("Invoking validateANdSave in ServiceImpl");
        boolean isValid = false;
        if (entity != null) {
            isValid = repository.saveLaptopInfo(entity);
        } else {
            isValid = false;
        }
        return isValid;
    }

    @Override
    public boolean validateAndUpdatePriceQuantityById(int id, String company, String brand, double price, int quantity, String processor) {
        System.out.println("Invoking validateAndUpdatePriceQuantityMfnById");
        boolean isValid = false;

        if (price > 0.0d && quantity > 0 && brand != null && !brand.isEmpty() && id > 0) {
            isValid = repository.updateCompanyCategoryQuantityById(company, brand, price, quantity, processor, id);


            System.out.println("Process successful");
        } else {
            System.out.println("Process failed");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public String validateAndUpdateAllDetailsById(LaptopEntity entity) {
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
    public boolean validateDeleteById(int i) {
        System.out.println("Invoking Validation");
        boolean isDeleted = false;
        if (i > 0) {
            isDeleted = repository.deleteById(i);
        } else {
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public LaptopEntity validateAndFindLaptopById(int id) {
        System.out.println("Invoking validation");
        LaptopEntity validFetch = null;

        if (id > 0) {
            validFetch = repository.findLaptopEntityById(id);
        }
        return validFetch;
    }


}



