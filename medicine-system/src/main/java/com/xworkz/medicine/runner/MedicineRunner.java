package com.xworkz.medicine.runner;

import com.xworkz.medicine.entity.MedicineEntity;
import com.xworkz.medicine.service.MedicineService;
import com.xworkz.medicine.service.MedicineServiceImpl;

import java.util.List;

public class MedicineRunner {

    public static void main(String[] args) {

        MedicineEntity medicine = new MedicineEntity();
        medicine.setName("Paracetamol");
        medicine.setManufacturer("Cipla");
        medicine.setPrice(50);
        medicine.setQuantity(500);
        medicine.setExpiryDate("2025-12-31");

        MedicineService service = new MedicineServiceImpl();



        // Fetch all
        List<MedicineEntity> medicines = service.validateAndFindAll();
        System.out.println(medicines);




    }
}
