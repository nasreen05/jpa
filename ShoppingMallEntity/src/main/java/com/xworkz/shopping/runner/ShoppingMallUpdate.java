package com.xworkz.shopping.runner;

import com.xworkz.shopping.entity.ShoppingMall;

import javax.persistence.*;

public class ShoppingMallUpdate {
    public static void main(String[] args) {
        ShoppingMall mall = new ShoppingMall();
        mall.setMallName("Phoenix Mall");
        mall.setLocation("Bangalore");
        mall.setShopsCount(250);


        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("something");
            System.out.println("EntityManagerFactory create : " + emf);

            em = emf.createEntityManager(); // DML insert, update, delete
            et = em.getTransaction();
            et.begin();

             ShoppingMall entity = em.find(ShoppingMall.class, 1);
            System.out.println("Old data : " + entity);

             entity.setMallName("Phoenix Marketcity");
            entity.setLocation("Chennai");
            entity.setShopsCount(300);

            ShoppingMall updatedEntity = em.merge(entity);
            System.out.println("Updated data : " + updatedEntity);

            et.commit();
            System.out.println("Shopping mall updated successfully");

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