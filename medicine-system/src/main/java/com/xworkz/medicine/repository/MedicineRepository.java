package com.xworkz.medicine.repository;

import com.xworkz.medicine.entity.MedicineEntity;

import java.util.List;

public interface  MedicineRepository {

        String saveMedicine(MedicineEntity entity);
       MedicineEntity updateAllDetailsById(MedicineEntity entity);
        boolean deleteById(int medicine_id);
        MedicineEntity findMedicineById(int medicine_id);
        List<MedicineEntity> findAllMedicines();

    boolean updatePriceQuantityMfdById(int medicineId, double price, int quantity, String expiryDate);
}




















