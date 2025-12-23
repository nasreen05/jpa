package com.xworkz.furniture.service;

import com.xworkz.furniture.entity.FurnitureEntity;

import java.util.List;

public interface FurnitureService {
    String validateAndSave(FurnitureEntity entity);
    boolean validateAndUpdatePriceQuantityMfdById(int furniture_id, String name, String material, double price, int quantity, String mfd);
    FurnitureEntity validateAllDetailsById(FurnitureEntity entity);
    boolean validateDeleteById(int furniture_id);
    FurnitureEntity ValidateAndFindFurnitureEntityById(int furniture_id);
    List<FurnitureEntity> validateAndFindAllFurnitureDetails();



}
