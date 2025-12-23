package com.xworkz.furniture.repository;

import com.xworkz.furniture.entity.FurnitureEntity;

import java.util.List;

public interface FurnitureRepository {
    String saveFurnitureInfo(FurnitureEntity entity);
    boolean updatePriceQuantityMfdById(int furniture_id, String name, String material, double price, int quantity, String mfd);
    FurnitureEntity updateAllDetailsById(FurnitureEntity entity);
    boolean deleteById(int furniture_id);
    FurnitureEntity findFurnitureEntityById(int furniture_id);
    List<FurnitureEntity> findAllFurnitureDetails();
}
