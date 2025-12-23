package com.xworkz.furniture.runner;

import com.xworkz.furniture.entity.FurnitureEntity;
import com.xworkz.furniture.service.FurnitureService;
import com.xworkz.furniture.service.FurnitureServiceImpl;

import java.util.List;

public class FurnitureRunner {
    public static void main(String[] args) {

        FurnitureEntity entity = new FurnitureEntity();
        entity.setName("Chair");
        entity.setMaterial("wood");
        entity.setPrice(2500.00);
        entity.setQuantity(20);
        entity.setMfd("2023-01-10");



        FurnitureService furnitureService = new FurnitureServiceImpl();



        List<FurnitureEntity> furnitureEntityList = furnitureService.validateAndFindAllFurnitureDetails();
        System.out.println(furnitureEntityList);
    }
}




























