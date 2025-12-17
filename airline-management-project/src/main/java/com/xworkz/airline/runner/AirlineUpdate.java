package com.xworkz.airline.runner;

import com.xworkz.airline.entity.AirlineEntity;

import javax.persistence.*;

public class AirlineUpdate {
    public static void main(String[] args) {

        AirlineEntity airline = new AirlineEntity();
        airline.setAirlineName("IndiGo");
        airline.setCountry("India");
        airline.setFleetSize(300);


        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;


        try {
            emf = Persistence.createEntityManagerFactory("something");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            AirlineEntity entity = em.find(AirlineEntity.class, 1);
            System.out.println("Old data " + entity);
            entity.setCountry("Kolkata");
            AirlineEntity updateEntity = em.merge(entity);
            System.out.println("Update data" + updateEntity);
            et.commit();
        } catch (
                PersistenceException e) {
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

