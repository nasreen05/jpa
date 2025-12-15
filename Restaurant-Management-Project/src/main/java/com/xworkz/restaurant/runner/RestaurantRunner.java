package com.xworkz.restaurant.runner;

import com.xworkz.restaurant.entity.RestaurantEntity;

import javax.persistence.*;
    public class RestaurantRunner {

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
                System.out.println("EntityManagerFactory created : " + emf);

                em = emf.createEntityManager();
                et = em.getTransaction();

                et.begin();
                em.persist(restaurant);
                et.commit();

                System.out.println("Restaurant data inserted");
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
