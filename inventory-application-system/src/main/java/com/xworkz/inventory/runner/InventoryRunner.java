package com.xworkz.inventory.runner;

import com.xworkz.inventory.entity.InventoryEntity;
import com.xworkz.inventory.service.InventoryService;
import com.xworkz.inventory.service.InventoryServiceImpl;

public class InventoryRunner {
    public static void main(String[] args) {

        InventoryEntity inventory = new InventoryEntity();
        inventory.setItemName("Steel Bolts");
        inventory.setCategory("Hardware");
        inventory.setQuantity(1200);
        inventory.setWarehouseLocation("Banglore-WH1");
        inventory.setLastUpdate("2025-01-01");

        InventoryEntity inventory1 = new InventoryEntity();
//        inventory1.setItemName("Packing Box");
//        inventory1.setCategory("Packaging");
//        inventory1.setQuantity(5000);
//        inventory1.setWarehouseLocation("Banglore-WH2");
//        inventory1.setLastUpdate("2025-04-01");

        InventoryService inventoryService = new InventoryServiceImpl();
//        boolean insert = inventoryService.validateAndSaveInventoryInfo(inventory);
//        System.out.println(insert);

//        boolean update = inventoryService.validateAndUpdateItemNameCategoryquantityById("Lubricant Oil", "Maintenance", 300, 2);
//        if (update) {
//            System.out.println("update successful......");
//        } else {
//            System.out.println("update failed");
//        }


//        InventoryEntity inventory2 = new InventoryEntity();
//        inventory2.setId(2);
//        inventory2.setItemName("Safety Gloves");
//        inventory2.setCategory("Safety");
//        inventory2.setQuantity(900);
//        inventory2.setWarehouseLocation("Hyderabad");
//        inventory2.setLastUpdate("2025-01-13");
//
//        String change = inventoryService.validateAndUpdateAllDetailsById(inventory2);
//        System.out.println(change + "...................");

        boolean deleted = inventoryService.validateAndDeleteById(1);
        if (deleted) {
            System.out.println("delete successful");
        } else {
            System.out.println("delete failed");
        }

        InventoryEntity fetching = inventoryService.validAndFindInventoryById(2);
        System.out.println(fetching);
    }
}
