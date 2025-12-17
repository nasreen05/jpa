package com.xworkz.flight.runner;

import com.xworkz.flight.entity.FlightEntity;

import javax.persistence.*;

public class FlightUpdate {
    public static void main(String[] args) {

        FlightEntity flight = new FlightEntity();
        flight.setFlightName("IndiGo 6E");
        flight.setSource("Delhi");
        flight.setDestination("Pune");


        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("something");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            FlightEntity entity = em.find(FlightEntity.class, 1);
            System.out.println("Old data " + entity);
            entity.setSource("Kolkata");
            FlightEntity updateEntity = em.merge(entity);
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

