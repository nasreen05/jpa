package com.xworkz.powerBank.repository;

import com.xworkz.powerBank.entity.PowerBankEntity;

public interface PowerBankRepository {




    boolean savePowerBankInfo (PowerBankEntity entity);


    String updateAllDetailsById(PowerBankEntity entity);

    boolean deleteById(int powerbank_id);

    PowerBankEntity findPowerBankEntityById(int powerbank_id);


    boolean updateBandCategoryQuantityById(int capacity, String brand, double price, int powerbank_id);
}
