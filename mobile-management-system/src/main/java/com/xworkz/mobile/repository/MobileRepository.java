package com.xworkz.mobile.repository;


import com.xworkz.mobile.entity.MobileEntity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public interface MobileRepository {
    String saveMobileInfo(MobileEntity entity);
    boolean updatePriceQuantityMfdById(double price, int quantity, String mfd, int id);
    MobileEntity updateAllDetailsById(MobileEntity entity);
    boolean deleteById(int id);
    MobileEntity findMobileEntityById(int id);

    List<MobileEntity> getMobileEntityByMfdAndPriceAndQuantity(String mfd, double price, int quantity);

    List<MobileEntity> getMobileEntityByBrandAndPrice(String brand, double price);

    List<MobileEntity> findByName(String oppo);
    List<MobileEntity> getMobileEntityByNameAndBrandAndPriceAndQuantity(String name, String brand ,double price, int quantity );
}
