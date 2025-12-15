package com.xworkz.airline.runner;

import com.xworkz.airline.entity.AirlineEntity;

import javax.persistence.*;

public class AirlineRunner {
    public static void main(String[] args) {
        AirlineEntity airline = new AirlineEntity();
        airline.setAirlineName("IndiGo");
        airline.setCountry("India");
        airline.setFleetSize(300);


        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;



        try{
            emf = Persistence.createEntityManagerFactory("something");
            System.out.println("EntityManagerFactory create : " + emf);
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(airline);
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
