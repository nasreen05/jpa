package com.xworkz.hotel.runner;

import com.xworkz.hotel.entity.HotelEntity;

import javax.persistence.*;

public class HotelUpdate {
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

            et.begin();
              HotelEntity entity = em.find(HotelEntity.class, 1);
            System.out.println("Old data : " + entity);
            entity.setHotelName("Taj Residency Palace");
            entity.setRating(5);
            entity.setCity("Mumbai");
            HotelEntity updatedEntity = em.merge(entity);
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