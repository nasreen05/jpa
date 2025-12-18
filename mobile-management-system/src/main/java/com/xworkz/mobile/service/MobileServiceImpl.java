package com.xworkz.mobile.service;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.repository.MobileRepository;
import com.xworkz.mobile.repository.MobileRepositoryImpl;

public class MobileServiceImpl implements MobileService{

    MobileRepository repository = new MobileRepositoryImpl();

    @Override
    public String validateAndSave(MobileEntity entity) {
        System.out.println("Invoking validateANdSave in ServiceImpl");
        String isValid = null;
        if (entity != null) {
            isValid = repository.saveMobileInfo(entity);
        } else {
            isValid = "Entity is null, cannot save";
        }
        return isValid;
    }

    @Override
    public boolean validateAndUpdatePriceQuantityMfdById(double price, int quantity, String mfd, int id) {
        System.out.println("Invoking validateAndUpdatePriceQuantityMfnById");
        boolean isValid = false;

        System.out.println(price);
        System.out.println(quantity);
        System.out.println(mfd);
        System.out.println(id);
        if (price>0.0d && quantity>0 && mfd!=null && !mfd.isEmpty() && id>0) {
            System.out.println("Initiating process");
            isValid = repository.updatePriceQuantityMfdById(price,quantity, mfd, id);
            System.out.println("Process successful");
        } else {
            System.out.println("Process failed");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public MobileEntity validateAllDetailsById(MobileEntity entity) {
        System.out.println("Invoking validation");
        MobileEntity isValidated = null;
        if (entity != null) {
            isValidated = repository.updateAllDetailsById(entity);
        } else {
            isValidated = null;
        }
        return isValidated;
    }


}
