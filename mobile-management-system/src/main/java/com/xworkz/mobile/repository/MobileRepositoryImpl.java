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
            emf = Persistence.createEntityManagerFactory("something");
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

    @Override
    public boolean updatePriceQuantityMfdById(double price, int quantity, String mfd, int id) {
        System.out.println("Invoking updatePriceQuantityMfdById in RepositoryImpl");
        boolean isUpdate = false;
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("something");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            MobileEntity entity = em.find(MobileEntity.class, id);
            if (entity != null) {
                entity.setPrice(price);
                entity.setQuantity(quantity);
                entity.setMfd(mfd);
                em.merge(entity);
                et.commit();
                isUpdate = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            isUpdate = false;
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return isUpdate;
    }

    @Override
    public MobileEntity updateAllDetailsById(MobileEntity entity) {
        System.out.println("Updated using Id");
        MobileEntity isUpdated = null;
        EntityManager em = null;
        EntityTransaction et = null;
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("something");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            MobileEntity mobileEntity = em.find(MobileEntity.class, 2);
            mobileEntity.setName(entity.getName());
            mobileEntity.setBrand(entity.getBrand());
            mobileEntity.setPrice(entity.getPrice());
            mobileEntity.setQuantity(entity.getQuantity());
            mobileEntity.setMfd(entity.getMfd());
            et.commit();
            isUpdated= em.merge(mobileEntity);
            System.out.println("data updated");
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return isUpdated;
    }

}