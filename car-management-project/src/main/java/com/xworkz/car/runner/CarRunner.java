package com.xworkz.car.runner;
import com.xworkz.car.entity.CarEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class CarRunner {

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
            em.persist(car);
            System.out.println("Car data inserted successfully");
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
