package com.xworkz.bike.runner;

import com.xworkz.bike.entity.BikeEntity;

import javax.persistence.*;

public class BikeUpdate {
    public static void main(String[] args) {
        BikeEntity bike = new BikeEntity();
        bike.setBrand("Yamaha");
        bike.setModel("R15");
        bike.setPrice(180000);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

            try {
                emf = Persistence.createEntityManagerFactory("something");
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();


                BikeEntity entity = em.find(BikeEntity.class, 1);
                System.out.println("Old data : " + entity);
                entity.setBrand("Yamaha");
                entity.setModel("R15 V4");
                entity.setPrice(195000);

                BikeEntity updatedEntity = em.merge(entity);
                System.out.println("Updated data : " + updatedEntity);

                et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            et.rollback();
        }finally {
            if(emf !=null){
                emf.close();}
            if(em!=null){
                em.close();

            }
        }


    }
}
