package com.xworkz.flight.runner;

import com.xworkz.flight.entity.FlightEntity;

import javax.persistence.*;

public class FlightRunner {
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
            System.out.println("EntityManagerFactory created: " + emf);

            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(flight);
            System.out.println("flight data inserted successfully");
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
