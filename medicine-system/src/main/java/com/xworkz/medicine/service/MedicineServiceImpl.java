package com.xworkz.medicine.service;

import com.xworkz.medicine.entity.MedicineEntity;
import com.xworkz.medicine.repository.MedicineRepository;
import com.xworkz.medicine.repository.MedicineRepositoryImpl;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    MedicineRepository repository = new MedicineRepositoryImpl();

    @Override
    public String validateAndSave(MedicineEntity entity) {
        System.out.println("Invoking validateANdSave in ServiceImpl");
        String isValid = null;
        if (entity != null) {
            isValid = repository.saveMedicine(entity);
        } else {
            isValid = "Entity is null, cannot save";
        }
        return isValid;
    }

    @Override
    public boolean validateAndUpdatePriceQuantityExpiryById(double price, int quantity, String expiryDate, int medicine_id) {
        System.out.println("Invoking validateAndUpdatePriceQuantityMfnById");
        boolean isValid = false;

        System.out.println(price);
        System.out.println(quantity);
        System.out.println(expiryDate);
        System.out.println(medicine_id);
        if (price>0.0d && quantity>0 && expiryDate!=null && !expiryDate.isEmpty() && medicine_id>0) {
            System.out.println("Initiating process");
            isValid = repository.updatePriceQuantityMfdById( medicine_id,price, quantity,expiryDate);
            System.out.println("Process successful");
        } else {
            System.out.println("Process failed");
            isValid = false;
        }
        return isValid;
    }


    @Override
    public MedicineEntity validateAllDetailsById(MedicineEntity entity) {
        System.out.println("Invoking validation");
        MedicineEntity isValidated = null;
        if (entity != null) {
            isValidated = repository.updateAllDetailsById(entity);
        } else {
            isValidated = null;
        }
        return isValidated;
    }

    @Override
    public boolean validateDeleteById(int medicine_id) {
        System.out.println("Invoking Validation");
        boolean isDeleted = false;
        if (medicine_id>0) {
            isDeleted = repository.deleteById(medicine_id);
        } else {
            isDeleted = false;
        }
        return isDeleted;
    }


    @Override
    public MedicineEntity validateAndFindById(int medicine_id) {
        System.out.println("Invoking validation");
        MedicineEntity validFetch = null;

        if (medicine_id > 0) {
            validFetch = repository.findMedicineById(medicine_id);
        }
        return validFetch;
    }

    @Override
    public List<MedicineEntity> validateAndFindAll() {

        System.out.println("Invoking validateAndFindAll in ServiceImpl");
        List<MedicineEntity> list = repository.findAllMedicines();
        if (list!=null && !list.isEmpty()) {
            System.out.println("Mobile entities found: " + list.size());
        }
        return list;
    }
}
