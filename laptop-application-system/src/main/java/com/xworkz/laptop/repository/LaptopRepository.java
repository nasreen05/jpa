package com.xworkz.laptop.repository;

import com.xworkz.laptop.entity.LaptopEntity;

public interface LaptopRepository {

boolean saveLaptopInfo (LaptopEntity entity);

boolean updateCompanyCategoryQuantityById(String company ,String brand , double price, int id, String processor , int quantity);

    String updateAllDetailsById(LaptopEntity entity);

    boolean deleteById(int id);

    LaptopEntity findLaptopEntityById(int id);

}






