package com.xworkz.laptop.repository;

import com.xworkz.laptop.entity.LaptopEntity;

import javax.annotation.processing.Processor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LaptopRepositoryImpl implements  LaptopRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("something");

    @Override
    public boolean saveLaptopInfo(LaptopEntity entity) {
        System.out.println("Invoking saveMobileInfo in RepositoryImpl");
        boolean isSaved = false;


        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
            isSaved=true;

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            isSaved=true;
        } finally {
            if (em != null) {
                em.close();
            }

        }
        return isSaved;

    }

    @Override
    public boolean updateCompanyCategoryQuantityById(String company, String brand, double price, int id, String processor, int quantity) {
        System.out.println("Invoking update");
        boolean update = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            LaptopEntity entity = em.find(LaptopEntity.class, id);
            if (entity != null) {
                entity.setCompany(company);
                entity.setProcessor(processor);
                entity.setQuantity(quantity);
                em.merge(entity);
                et.commit();
                update = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            update = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return update;
    }

    @Override
    public String  updateAllDetailsById(LaptopEntity entity) {
        System.out.println("Updated using Id");
        String isUpdated = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            LaptopEntity laptopEntity = em.find(LaptopEntity.class, 3);
            laptopEntity.setCompany(entity.getCompany());
            laptopEntity.setBrand(entity.getBrand());
            laptopEntity.setPrice(entity.getPrice());
            laptopEntity.setQuantity(entity.getQuantity());
            laptopEntity.setProcessor(entity.getProcessor());
            et.commit();
            isUpdated ="Successfully done ";
            System.out.println("OLD :"+ entity.getBrand());
            System.out.println(" NEW : data updated" +entity.getBrand());
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
    public boolean deleteById(int id) {
        System.out.println("Deleting using Id");
        boolean delete = false;


        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            LaptopEntity find = em.find(LaptopEntity.class, id);
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
    public LaptopEntity findLaptopEntityById(int id) {
        System.out.println("fetching data by implementation");
        LaptopEntity foundEntity = null;

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            foundEntity = em.find(LaptopEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return foundEntity;
    }
}


