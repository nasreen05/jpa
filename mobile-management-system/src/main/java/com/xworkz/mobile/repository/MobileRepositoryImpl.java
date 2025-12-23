package com.xworkz.mobile.repository;


import com.xworkz.mobile.entity.MobileEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class MobileRepositoryImpl implements MobileRepository {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("something");

    @Override
    public String saveMobileInfo(MobileEntity entity) {
        System.out.println("Invoking saveMobileInfo in RepositoryImpl");
        String isSaved = null;


        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
           em.persist(entity);
            MobileEntity search = em.find(MobileEntity.class,1);
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

        }
        return isSaved;

    }

    @Override
    public boolean updatePriceQuantityMfdById(double price, int quantity, String mfd, int id) {
        System.out.println("Invoking updatePriceQuantityMfdById in RepositoryImpl");
        boolean isUpdate = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {

            em = this.emf.createEntityManager();
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

        }
        return isUpdate;
    }

    @Override
    public MobileEntity updateAllDetailsById(MobileEntity entity) {
        System.out.println("Updated using Id");
        MobileEntity isUpdated = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {

            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            MobileEntity mobileEntity = em.find(MobileEntity.class, 4);
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
            MobileEntity find = em.find(MobileEntity.class, id);
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
    public MobileEntity findMobileEntityById(int id) {
        System.out.println("fetching data by implementation");
        MobileEntity foundEntity = null;

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            foundEntity = em.find(MobileEntity.class, id);
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
    public List<MobileEntity> getMobileEntityByMfdAndPriceAndQuantity(String mfd, double price, int quantity) {

        System.out.println("Invoking getMobileEntityByMfdAndPriceAndQuantity in RepositoryImpl");

        List<MobileEntity> mobileEntityList = null;
        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();

            Query query = em.createNamedQuery(
                    "getMobileEntityByMfdAndPriceAndQuantity"
            );

            query.setParameter("mfd", mfd);
            query.setParameter("price", price);
            query.setParameter("quantity", quantity);

            mobileEntityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return mobileEntityList;
    }



    @Override
        public List<MobileEntity> getMobileEntityByBrandAndPrice(String brand, double price) {
            System.out.println("fetching getMobileEntityByBrandAndPrice()");
            List<MobileEntity> fetching = null;

            EntityManager em = null;

            try {
                em = this.emf.createEntityManager();
                Query query = em.createNamedQuery("getBrandAndPrice");
                query.setParameter("brand", brand);
                query.setParameter("price", price);
                fetching = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
            return fetching;
        }

    @Override
    public List<MobileEntity> findByName(String oppo) {
        System.out.println("fetching find By name()");
        List<MobileEntity> fetching = null;

        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();
          //  Query query = em.createNamedQuery("findByName");

            Query query = em.createQuery("select m from MobileEntity m where m.name=: name");

            query.setParameter("name", oppo);

            fetching = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return fetching;
    }

    @Override
    public List<MobileEntity> getMobileEntityByNameAndBrandAndPriceAndQuantity(String name, String brand, double price, int quantity) {
        System.out.println(" fetching  getMobileEntityByNameAndBrandAndPriceAndQuantity()");
        List<MobileEntity> mobileEntityList = null;
        EntityManager em = null;

        try {
            em = this.emf.createEntityManager();

            Query query = em.createNamedQuery(
                    "getNameAndBrandAndPriceAndQuantity"
            );

            query.setParameter("name", name);
            query.setParameter("brand", brand);
            query.setParameter("price", price);
            query.setParameter("quantity", quantity);

            mobileEntityList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return mobileEntityList;
    }


}



