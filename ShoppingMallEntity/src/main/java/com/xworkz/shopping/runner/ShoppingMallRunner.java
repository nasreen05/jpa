package com.xworkz.shopping.runner;
import com.xworkz.shopping.entity.ShoppingMall;

import javax.persistence.*;
public class ShoppingMallRunner {
    public static void main(String[] args) {
        ShoppingMall mall = new ShoppingMall();
        mall.setMallName("Phoenix Mall");
        mall.setLocation("Bangalore");
        mall.setShopsCount(250);


     //    EntityManagerFactory emf = Persistence.createEntityManagerFactory("something");
      //  EntityManager em = emf.createEntityManager();
      //   EntityTransaction et = em.getTransaction();



        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;





        try{
            emf = Persistence.createEntityManagerFactory("something");
            System.out.println("EntityManagerFactory create : " + emf);
            em = emf.createEntityManager(); // DML insert, update, delete, DQL select
            et = em.getTransaction();
            et.begin();

            em.persist(mall);
            System.out.println("shopping  inserted");
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            et.rollback();
        }finally {
            if(emf !=null){
                emf.close();}
            if(em!=null){
                em.close();

            }
        }

    }
}
