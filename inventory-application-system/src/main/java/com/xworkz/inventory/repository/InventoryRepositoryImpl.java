package com.xworkz.inventory.repository;

import com.xworkz.inventory.entity.InventoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InventoryRepositoryImpl implements  InventoryRepository{
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("something");

    @Override
    public boolean saveInventoryInfo(InventoryEntity entity) {
        System.out.println("Inserting data");
        boolean insert = false;


        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
            insert = true;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
            insert = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return insert;
    }


    @Override
    public boolean updateItemNameCategoryQuantityById(String itemName, String category, int quantity, int id) {
        System.out.println("Invoking update");
        boolean update = false;

        EntityManager em = null;
        EntityTransaction et = null;
        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            InventoryEntity sru = em.find(InventoryEntity.class, id);
            if (sru != null) {
                sru.setItemName(itemName);
                sru.setCategory(category);
                sru.setQuantity(quantity);
                em.merge(sru);
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
    public String updateAllDetailsById(InventoryEntity entity) {
        System.out.println("Update details by Id");
        String isUpdate = null;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            InventoryEntity entityUpdate = em.find(InventoryEntity.class, 2);
            entityUpdate.setItemName(entity.getItemName());
            entityUpdate.setCategory(entity.getCategory());
            entityUpdate.setQuantity(entity.getQuantity());
            entityUpdate.setWarehouseLocation(entity.getWarehouseLocation());
            entityUpdate.setLastUpdate(entity.getLastUpdate());
            et.commit();
            isUpdate = "successfully done";
            System.out.println("OLD: " + entityUpdate.getItemName());
            System.out.println("NEW: " + entity.getItemName());

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return isUpdate;
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("deleting using id");
        boolean isdelete = false;

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            InventoryEntity entity = em.find(InventoryEntity.class, id);
            em.remove(entity);
            et.commit();
            isdelete = true;
            System.out.println("Delete Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return isdelete;
    }

    @Override
    public InventoryEntity findInventoryById(int id) {
        System.out.println("Fetching Invoked");
        InventoryEntity fetch = null;

        EntityManager em = null;
        EntityTransaction et = null;


        try {
            em = this.emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            fetch = em.find(InventoryEntity.class, id);
            et.commit();

        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return fetch;
    }
}
