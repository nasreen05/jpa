package com.xworkz.charger.repository;


import com.xworkz.charger.entity.ChargerEntity;

public interface ChargerRepository {
    boolean saveChargerInfo(ChargerEntity entity);
boolean updatePriceQuantityById(double price, String brand, int power, int id);
String updateAllDetailsById(ChargerEntity entity);
boolean deleteById(int id);
ChargerEntity findChargerEntityById(int id);
}
