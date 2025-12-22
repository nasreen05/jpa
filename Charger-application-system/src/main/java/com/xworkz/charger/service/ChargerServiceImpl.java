package com.xworkz.charger.service;

import com.xworkz.charger.entity.ChargerEntity;
import com.xworkz.charger.repository.ChargerRepository;
import com.xworkz.charger.repository.ChargerRepositoryImpl;

public class ChargerServiceImpl implements  ChargerService{
    ChargerRepository repository = new ChargerRepositoryImpl();

    @Override
    public boolean validateAndSave(ChargerEntity entity) {
        System.out.println("Invoking validation");
        boolean saveValid = false;

        if (entity != null) {
            saveValid = repository.saveChargerInfo(entity);
        } else {
            saveValid = false;
        }
        return saveValid;
    }

    @Override
    public boolean validateAndUpdatePriceQuantityMfdById(double price, int id, String brand, int power) {
        System.out.println("Invoking validation");
        boolean updateValid = false;

        if (brand!=null && !brand.isEmpty()  && power>0 && id>0) {
            updateValid = repository.updatePriceQuantityById(price,brand, power, id);
        } else {
            updateValid = false;
        }
        return updateValid;
    }

    @Override
    public String validateAndUpdateAllDetailsById(ChargerEntity entity) {
        System.out.println("Invoking validation");
        String isValidated = null;

        if (entity != null) {
            isValidated = repository.updateAllDetailsById(entity);
        } else {
            isValidated = null;
        }
        return isValidated;
    }
    

    @Override
    public boolean validateDeleteById(int id) {
        System.out.println("Invoking Validation");
        boolean isDeleted = false;
        if (id>0) {
            isDeleted = repository.deleteById(id);
        } else {
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public ChargerEntity validateAndFindMobileEntityById(int id) {
        System.out.println("Invoking validation");
        ChargerEntity validFetch = null;

        if (id > 0) {
            validFetch = repository.findChargerEntityById(id);
        }
        return validFetch;
    }
}
