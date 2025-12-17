package com.xworkz.car.runner;

import com.xworkz.car.entity.CarEntity;

import javax.persistence.*;

public class CarUpdate {
    public static void main(String[] args) {

        CarEntity car = new CarEntity();
        car.setBrand("Toyota");
        car.setModel("Fortuner");
        car.setPrice(4500000);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;



            try {
                emf = Persistence.createEntityManagerFactory("something");
                System.out.println("EntityManagerFactory created: " + emf);

                em = emf.createEntityManager();
                et = em.getTransaction();

                et.begin();

                CarEntity entity = em.find(CarEntity.class, 1);
                System.out.println("Old data : " + entity);


                entity.setBrand("Toyota");
                entity.setModel("Fortuner Legender");
                entity.setPrice(4800000);

                CarEntity updatedEntity = em.merge(entity);
                System.out.println("Updated data : " + updatedEntity);

                et.commit();



            } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}