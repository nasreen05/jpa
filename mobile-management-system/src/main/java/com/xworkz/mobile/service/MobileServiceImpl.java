package com.xworkz.mobile.service;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.repository.MobileRepository;
import com.xworkz.mobile.repository.MobileRepositoryImpl;

public class MobileServiceImpl implements MobileService {

    MobileRepository repository = new MobileRepositoryImpl();

    @Override
    public String validateAndSave(MobileEntity entity) {

        System.out.println("Invoking validateAndSave in ServiceImpl");

        String isValid = null;

        if (entity != null) {
            isValid = repository.saveMobileInfo(entity);
        } else {
            isValid = "Entity is null, cannot save";
        }
        return isValid;
    }
}
