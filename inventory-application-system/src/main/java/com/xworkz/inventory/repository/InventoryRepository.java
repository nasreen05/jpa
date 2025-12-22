package com.xworkz.inventory.repository;

import com.xworkz.inventory.entity.InventoryEntity;

public interface InventoryRepository {

    boolean saveInventoryInfo(InventoryEntity entity);
    boolean updateItemNameCategoryQuantityById(String itemName, String category, int quantity, int id);
    String updateAllDetailsById(InventoryEntity entity);
    boolean deleteById(int id);
    InventoryEntity findInventoryById(int id);
}
