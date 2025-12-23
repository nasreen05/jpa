package com.xworkz.furniture.repository;

import com.xworkz.furniture.entity.FurnitureEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class FurnitureRepositoryImpl implements  FurnitureRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("something");

    @Override
    public String saveFurnitureInfo(FurnitureEntity entity) {

        System.out.println("Invoking saveFurnitureInfo in RepositoryImpl");
            String isSaved = null;

            EntityManager em = null;
            EntityTransaction et = null;

            try {
                em = this.emf.createEntityManager();
                et = em.getTransaction();
                et.begin();
                em.persist(entity);
                et.commit();
                isSaved = "Furniture info saved successfully";
            } catch (Exception e) {
                e.printStackTrace();
                et.rollback();
                isSaved = "Failed to save furniture info";
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        return isSaved;
    }


    @Override
    public boolean updatePriceQuantityMfdById(int furniture_id, String name, String material, double price, int quantity, String mfd) {
        System.out.println("Invoking updatePriceQuantityMfdById in RepositoryImpl");
        boolean isUpdate = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
             FurnitureEntity entity = em.find(FurnitureEntity.class, furniture_id);
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
        }
        return isUpdate;
    }


    @Override
    public FurnitureEntity updateAllDetailsById(FurnitureEntity entity) {
        System.out.println("Updated using Id");
        FurnitureEntity isUpdated = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            FurnitureEntity furnitureEntity = em.find(FurnitureEntity.class, 4);
            furnitureEntity.setName(entity.getName());
            furnitureEntity.setMaterial(entity.getMaterial());
            furnitureEntity.setPrice(entity.getPrice());
            furnitureEntity.setQuantity(entity.getQuantity());
            furnitureEntity.setMfd(entity.getMfd());
            et.commit();
            isUpdated= em.merge(furnitureEntity);
            System.out.println("data updated");
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return isUpdated;
    }

    @Override
    public boolean deleteById(int furniture_id) {
        System.out.println("Deleting using Id");
        boolean delete = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            FurnitureEntity find = em.find(FurnitureEntity.class, furniture_id);
            if (find != null) {
                em.remove(find);
                et.commit();
                delete = true;
                System.out.println("Deleted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            delete = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return delete;
    }

    @Override
    public FurnitureEntity findFurnitureEntityById(int furniture_id) {
        System.out.println("fetching data by implementation");
        FurnitureEntity foundEntity = null;
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            foundEntity = em.find(FurnitureEntity.class, furniture_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return foundEntity;
    }

    @Override
    public List<FurnitureEntity> findAllFurnitureDetails() {
        System.out.println("Invoking findAllFurnitureEntityIn RepositoryImpl");
        List<FurnitureEntity> mobileEntities = null;
        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();
            Query query = em.createNamedQuery("findAllFurnitureEntities");
            mobileEntities = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return mobileEntities;
    }
}