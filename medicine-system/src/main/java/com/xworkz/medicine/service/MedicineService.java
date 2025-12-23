package com.xworkz.medicine.service;

import com.xworkz.medicine.entity.MedicineEntity;
import java.util.List;

public interface MedicineService {
    String validateAndSave(MedicineEntity entity);
    boolean validateAndUpdatePriceQuantityExpiryById(double price, int quantity, String expiryDate, int medicine_id);
    MedicineEntity validateAllDetailsById(MedicineEntity entity);
    boolean validateDeleteById(int medicine_id);
    MedicineEntity validateAndFindById(int medicine_id);
    List<MedicineEntity> validateAndFindAll();
}
