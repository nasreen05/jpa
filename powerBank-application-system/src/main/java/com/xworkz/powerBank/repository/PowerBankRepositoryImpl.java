package com.xworkz.powerBank.repository;

import com.xworkz.powerBank.entity.PowerBankEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PowerBankRepositoryImpl implements  PowerBankRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("something");

    @Override
    public boolean savePowerBankInfo(PowerBankEntity entity) {
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
            isSaved = true;

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            isSaved = true;
        } finally {
            if (em != null) {
                em.close();
            }

        }
        return isSaved;

    }

    @Override
    public boolean updateBandCategoryQuantityById(int capacity, String brand, double price, int powerbankId) {
        System.out.println("Invoking update");
        boolean update = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            PowerBankEntity entity = em.find(PowerBankEntity.class, powerbankId);
            if (entity != null) {
                entity.setCapacity(capacity);
                entity.setBrand(brand);
                entity.setPrice(price);
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
    public String updateAllDetailsById(PowerBankEntity entity) {
        System.out.println("Updated using Id");
        String isUpdated = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            PowerBankEntity powerBankEntity = em.find(PowerBankEntity.class, 3);
            powerBankEntity.setCapacity(entity.getCapacity());
            powerBankEntity.setBrand(entity.getBrand());
            powerBankEntity.setPrice(entity.getPrice());

            et.commit();
            isUpdated = "Successfully done ";
            System.out.println("OLD :" + entity.getBrand());
            System.out.println(" NEW : data updated" + entity.getBrand());
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
            PowerBankEntity find = em.find(PowerBankEntity.class, id);
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
    public PowerBankEntity findPowerBankEntityById(int powerbank_id) {
        System.out.println("fetching data by implementation");
        PowerBankEntity foundEntity = null;

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            foundEntity = em.find(PowerBankEntity.class, powerbank_id);
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
