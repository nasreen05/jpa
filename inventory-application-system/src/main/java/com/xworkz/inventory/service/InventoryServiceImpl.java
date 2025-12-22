package com.xworkz.inventory.service;

import com.xworkz.inventory.entity.InventoryEntity;
import com.xworkz.inventory.repository.InventoryRepository;
import com.xworkz.inventory.repository.InventoryRepositoryImpl;

public class InventoryServiceImpl implements InventoryService {

    InventoryRepository repository = new InventoryRepositoryImpl();


    @Override
    public boolean validateAndSaveInventoryInfo(InventoryEntity entity) {
        System.out.println("Invoking validation");
        boolean saveValid = false;

        if (entity != null) {
            saveValid = repository.saveInventoryInfo(entity);
        } else {
            saveValid = false;
        }
        return saveValid;
    }
    @Override
    public boolean validateAndUpdateItemNameCategoryQuantityById(String itemName, String category, int quantity, int id) {
        System.out.println("Invoking validation");
        boolean updateValid = false;

        if (itemName!=null && !itemName.isEmpty() && category!=null && !category.isEmpty() && quantity>0 && id>0) {
            updateValid = repository.updateItemNameCategoryQuantityById(itemName, category, quantity, id);
        } else {
            updateValid = false;
        }
        return updateValid;
    }
    @Override
    public String validateAndUpdateAllDetailsById(InventoryEntity entity) {
        System.out.println("Invoking validation");
        String isValid = null;

        if (entity != null) {
            isValid = repository.updateAllDetailsById(entity);
        } else {
            System.out.println("Validation failed");
        }
        return isValid;
    }
    @Override
    public boolean validateAndDeleteById(int id) {
        System.out.println("Invoking validation");
        boolean validDelete = false;

        if (id>0) {
            validDelete = repository.deleteById(id);
        } else {
            validDelete = false;
        }
        return validDelete;
    }

    @Override
    public InventoryEntity validAndFindInventoryById(int id) {
        System.out.println("Invoking validation");
        InventoryEntity validDel = null;

        if (id > 0) {
            validDel = repository.findInventoryById(id);
        }
        return validDel;
    }
}
