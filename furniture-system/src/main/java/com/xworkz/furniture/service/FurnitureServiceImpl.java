package com.xworkz.furniture.service;

import com.xworkz.furniture.entity.FurnitureEntity;
import com.xworkz.furniture.repository.FurnitureRepository;
import com.xworkz.furniture.repository.FurnitureRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class FurnitureServiceImpl implements  FurnitureService {
    FurnitureRepository repository = new FurnitureRepositoryImpl();

    @Override
    public String validateAndSave(FurnitureEntity entity) {
        System.out.println("Invoking validateANdSave in ServiceImpl");
        String isValid = null;
        if (entity != null) {
            isValid = repository.saveFurnitureInfo(entity);
        } else {
            isValid = "Entity is null, cannot save";
        }
        return isValid;
    }


    @Override
    public boolean validateAndUpdatePriceQuantityMfdById(int furniture_id, String name, String material, double price, int quantity, String mfd) {
        System.out.println("Invoking validateAndUpdatePriceQuantityMfnById");
        boolean isValid = false;

        System.out.println(price);
        System.out.println(quantity);
        System.out.println(mfd);
        System.out.println(furniture_id);
        if (price>0.0d && quantity>0 && mfd!=null && !mfd.isEmpty() && furniture_id>0) {
            System.out.println("Initiating process");
            isValid = repository.updatePriceQuantityMfdById( furniture_id, name,material,price, quantity,mfd);
            System.out.println("Process successful");
        } else {
            System.out.println("Process failed");
            isValid = false;
        }
        return isValid;
    }


    @Override
    public FurnitureEntity validateAllDetailsById(FurnitureEntity entity) {
        System.out.println("Invoking validation");
        FurnitureEntity isValidated = null;
        if (entity != null) {
            isValidated = repository.updateAllDetailsById(entity);
        } else {
            isValidated = null;
        }
        return isValidated;
    }

    @Override
    public boolean validateDeleteById(int furniture_id) {
        System.out.println("Invoking Validation");
        boolean isDeleted = false;
        if (furniture_id>0) {
            isDeleted = repository.deleteById(furniture_id);
        } else {
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public FurnitureEntity ValidateAndFindFurnitureEntityById(int furniture_id) {
        System.out.println("Invoking validation");
        FurnitureEntity validFetch = null;

        if (furniture_id > 0) {
            validFetch = repository.findFurnitureEntityById(furniture_id);
        }
        return validFetch;
    }
    @Override
    public List<FurnitureEntity> validateAndFindAllFurnitureDetails() {

        System.out.println("Invoking validateAndFindAll in ServiceImpl");
        List<FurnitureEntity> list = repository.findAllFurnitureDetails();
        if (list!=null && !list.isEmpty()) {
            System.out.println("Mobile entities found: " + list.size());
        }
        return list;
    }
    }
