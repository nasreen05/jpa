package com.xworkz.mobile.repository;


import com.xworkz.mobile.entity.MobileEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;

public class MobileRepositoryImpl implements MobileRepository {


    @Override
    public String saveMobileInfo(MobileEntity entity) {
        System.out.println("Invoking saveMobileInfo in RepositoryImpl");
        String isSaved = null;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("mobile");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
//            em.persist(entity);
            MobileEntity search = em.find(MobileEntity.class,2);
            System.out.println(search);
            entity.setName("One Plus");
            MobileEntity update = em.merge(entity);
            System.out.println("Successfully updated: " + update);
            MobileEntity found = em.find(MobileEntity.class, 1);
            em.remove(found);
            et.commit();
            isSaved = "Mobile info saved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            isSaved = "Failed to save mobile info";
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return isSaved;

    }

}