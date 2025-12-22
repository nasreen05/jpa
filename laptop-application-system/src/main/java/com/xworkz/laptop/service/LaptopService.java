package com.xworkz.laptop.service;

import com.xworkz.laptop.entity.LaptopEntity;

public interface LaptopService {
    boolean validateAndSaveLaptopInfo(LaptopEntity entity);
    boolean validateAndUpdatePriceQuantityById(int id, String company, String  brand, double price, int quantity, String  processor);
    String  validateAndUpdateAllDetailsById(LaptopEntity entity);

    LaptopEntity validateAndFindLaptopById(int id);

    boolean validateDeleteById(int i);
}