package com.xworkz.hotel.runner;







import com.xworkz.hotel.entity.HotelEntity;

import javax.persistence.*;


public class HotelRunner {

    public static void main(String[] args) {

        HotelEntity hotel = new HotelEntity();
        hotel.setHotelName("Taj Residency");
        hotel.setRating(5);
        hotel.setCity("Bangalore");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("something");
            System.out.println("EntityManagerFactory created: " + emf);

            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();            // start transaction
            em.persist(hotel);     // insert data
            System.out.println("Hotel data inserted successfully");
            et.commit();           // commit transaction

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
