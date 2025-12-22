package com.xworkz.charger.service;

import com.xworkz.charger.entity.ChargerEntity;

public  interface ChargerService {
    boolean validateAndSave(ChargerEntity entity);
    boolean validateAndUpdatePriceQuantityMfdById(double price , int id, String brand ,int power  );
    String  validateAndUpdateAllDetailsById(ChargerEntity entity);
    boolean validateDeleteById(int id) ;
    ChargerEntity validateAndFindMobileEntityById(int id);
}
