package com.xworkz.mobile.service;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileService {
    String validateAndSave(MobileEntity entity);
    boolean validateAndUpdatePriceQuantityMfdById(double price, int quantity, String mfd, int id);
    MobileEntity validateAllDetailsById(MobileEntity entity);




}
