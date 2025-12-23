package com.xworkz.mobile.service;

import com.xworkz.mobile.entity.MobileEntity;

import java.util.List;

public interface MobileService {

    String validateAndSave(MobileEntity entity);

        boolean validateAndUpdatePriceQuantityMfdById(
                double price, int quantity, String mfd, int id);

        MobileEntity validateAllDetailsById(MobileEntity entity);

        boolean validateDeleteById(int id);

        MobileEntity ValidateAndFindMobileEntityById(int id);



    List<MobileEntity> validateAndGetMobileEntityByBrandAndPrice(String brand, double price) ;

    List<MobileEntity> findByName(String oppo);

    List<MobileEntity> findByMfdAndQuantityAndPrice(String date, double v, int i);

    List<MobileEntity> findByNameAndBrandAndPriceAndQuantity(String n , String b , double p , int q);

}
