package com.xworkz.bike.runner;
import com.xworkz.bike.entity.BikeEntity;

import javax.persistence.*;


public class BikeRunner {
    public static void main(String[] args) {
        BikeEntity bike = new BikeEntity();
        bike.setBrand("Yamaha");
        bike.setModel("R15");
        bike.setPrice(180000);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;



        try{
            emf = Persistence.createEntityManagerFactory("something");
            System.out.println("EntityManagerFactory create : " + emf);
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(bike);
            System.out.println("Movie date inserted");
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
