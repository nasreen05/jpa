package com.xworkz.novel.repository;

import com.xworkz.novel.entity.NovelEntity;

import javax.persistence.*;
import java.util.List;

public class NovelRepositoryImpl implements NovelRepository {

    static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("something");

    @Override
    public String saveNovelInfo(NovelEntity entity) {

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
            return "Novel saved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null) et.rollback();
            return "Failed to save novel";
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public boolean updatePricePagesYearById(double price, int pages, String year, int id) {

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            NovelEntity entity = em.find(NovelEntity.class, id);
            if (entity != null) {
                entity.setPrice(price);
                entity.setPages(pages);
                entity.setPublishedYear(year);
                em.merge(entity);
                et.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null) et.rollback();
        } finally {
            if (em != null) em.close();
        }
        return false;
    }

    @Override
    public NovelEntity updateAllDetailsById(NovelEntity entity) {

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            NovelEntity dbEntity = em.find(NovelEntity.class, entity.getNovelId());
            if (dbEntity != null) {
                dbEntity.setTitle(entity.getTitle());
                dbEntity.setAuthor(entity.getAuthor());
                dbEntity.setPrice(entity.getPrice());
                dbEntity.setPages(entity.getPages());
                dbEntity.setPublishedYear(entity.getPublishedYear());
                et.commit();
                return em.merge(dbEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null) et.rollback();
        } finally {
            if (em != null) em.close();
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {

        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            NovelEntity entity = em.find(NovelEntity.class, id);
            if (entity != null) {
                em.remove(entity);
                et.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null) et.rollback();
        } finally {
            if (em != null) em.close();
        }
        return false;
    }

    @Override
    public NovelEntity findNovelById(int id) {

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.find(NovelEntity.class, id);
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public List<NovelEntity> findAllNovelDetails() {

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createNamedQuery("findAllNovelEntities");
            return query.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
