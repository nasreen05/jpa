package com.xworkz.restaurant.runner;

import com.xworkz.restaurant.entity.RestaurantEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RestaurantUpdate {

        public static void main(String[] args) {

            RestaurantEntity restaurant = new RestaurantEntity();
            restaurant.setName("Food Junction");
            restaurant.setLocation("Hyderabad");
            restaurant.setRating(4.2f);

            EntityManagerFactory emf = null;
            EntityManager em = null;
            EntityTransaction et = null;

            try {
                emf = Persistence.createEntityManagerFactory("something");
                em = emf.createEntityManager();
                et = em.getTransaction();

                et.begin();

                  RestaurantEntity entity = em.find(RestaurantEntity.class, 1);
                System.out.println("Old data : " + entity);

                entity.setName("Food Junction Deluxe");
                entity.setLocation("Bangalore");
                entity.setRating(4.5f);

                RestaurantEntity updatedEntity = em.merge(entity);
                System.out.println("Updated data : " + updatedEntity);

                et.commit();
                System.out.println("Restaurant data updated successfully");

            } catch (Exception e) {
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
