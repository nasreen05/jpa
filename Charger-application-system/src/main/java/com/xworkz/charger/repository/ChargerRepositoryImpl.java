package com.xworkz.charger.repository;

import com.xworkz.charger.entity.ChargerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ChargerRepositoryImpl implements  ChargerRepository{
     static EntityManagerFactory emf= Persistence.createEntityManagerFactory("something");
    @Override
    public boolean saveChargerInfo(ChargerEntity entity) {
        System.out.println("Invoking  saveMobileInfo in Repository in  RepositoryImpl");
       boolean isSaved= false;

       EntityManager em=null;
        EntityTransaction et= null;

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
            isSaved = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return isSaved;
    }


    @Override
    public boolean updatePriceQuantityById(double price, String brand, int power, int id) {
        System.out.println("Invoking updatePriceQuantityMfdById in RepositoryImpl");
        boolean isUpdate = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ChargerEntity entity = em.find(ChargerEntity.class, id);
            if (entity != null) {
                entity.setPrice(price);
                entity.setPower(power);
                // entity.brand(brand);
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
    public String updateAllDetailsById(ChargerEntity entity) {
        System.out.println("Updated using Id");
        String  isUpdated = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            ChargerEntity chargerEntity = em.find(ChargerEntity.class, 2);

            chargerEntity.setBrand(entity.getBrand());
            chargerEntity.setPrice(entity.getPrice());
            chargerEntity.setPower(entity.getPower());

            et.commit();
            isUpdated= "Successfully Done";
            System.out.println("data updated");
            System.out.println("OLD: " + chargerEntity.getBrand());
            System.out.println("NEW: " + entity.getBrand());
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
            ChargerEntity find = em.find(ChargerEntity.class, id);
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
    public ChargerEntity findChargerEntityById(int id) {
        System.out.println("fetching data by implementation");
        ChargerEntity foundEntity = null;

        EntityManager em = null;
        try {
            em = emf.createEntityManager();

            foundEntity = em.find(ChargerEntity.class, id);
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
