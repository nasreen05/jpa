package com.xworkz.medicine.repository;

import com.xworkz.medicine.entity.MedicineEntity;

import javax.persistence.*;
import java.util.List;

public class MedicineRepositoryImpl implements MedicineRepository{

        static EntityManagerFactory emf = Persistence.createEntityManagerFactory("something");

        @Override
        public String saveMedicine(MedicineEntity entity) {
            EntityManager em = null;
            EntityTransaction et = null;
            String result;
            try {
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();
                em.persist(entity);
                et.commit();
                result = "Medicine saved successfully";
            } catch (Exception e) {
                e.printStackTrace();
                if (et != null) et.rollback();
                result = "Failed to save medicine";
            } finally {
                if (em != null) em.close();
            }
            return result;
        }

    @Override
    public boolean updatePriceQuantityMfdById(int medicineId, double price, int quantity, String expiryDate) {

           boolean updated = false;
            EntityManager em = null;
            EntityTransaction et = null;

            try {
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();
                MedicineEntity entity = em.find(MedicineEntity.class, medicineId);
                if (entity != null) {
                    entity.setPrice(price);
                    entity.setQuantity(quantity);
                    entity.setExpiryDate(expiryDate);
                    em.merge(entity);
                    et.commit();
                    updated = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (et != null) et.rollback();
            } finally {
                if (em != null) em.close();
            }

            return updated;
        }

        @Override
        public MedicineEntity updateAllDetailsById(MedicineEntity entity) {
            EntityManager em = null;
            EntityTransaction et = null;
            MedicineEntity updatedEntity = null;

            try {
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();
                MedicineEntity existing = em.find(MedicineEntity.class, entity.getMedicineId());
                if (existing != null) {
                    existing.setName(entity.getName());
                    existing.setManufacturer(entity.getManufacturer());
                    existing.setPrice(entity.getPrice());
                    existing.setQuantity(entity.getQuantity());
                    existing.setExpiryDate(entity.getExpiryDate());
                    updatedEntity = em.merge(existing);
                    et.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (et != null) et.rollback();
            } finally {
                if (em != null) em.close();
            }

            return updatedEntity;
        }

        @Override
        public boolean deleteById(int medicine_id) {
            boolean deleted = false;
            EntityManager em = null;
            EntityTransaction et = null;

            try {
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();
                MedicineEntity entity = em.find(MedicineEntity.class, medicine_id);
                if (entity != null) {
                    em.remove(entity);
                    et.commit();
                    deleted = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (et != null) et.rollback();
            } finally {
                if (em != null) em.close();
            }

            return deleted;
        }

        @Override
        public MedicineEntity findMedicineById(int medicine_id) {
            EntityManager em = null;
            MedicineEntity entity = null;

            try {
                em = emf.createEntityManager();
                entity = em.find(MedicineEntity.class, medicine_id);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) em.close();
            }

            return entity;
        }

        @Override
        public List<MedicineEntity> findAllMedicines() {
            EntityManager em = null;
            List<MedicineEntity> list = null;

            try {
                em = emf.createEntityManager();
                Query query = em.createNamedQuery("findAllMedicineEntities");
                list = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) em.close();
            }

            return list;
        }
}
