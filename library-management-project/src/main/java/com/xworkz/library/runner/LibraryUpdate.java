package com.xworkz.library.runner;

import com.xworkz.library.entity.LibraryEntity;

import javax.persistence.*;

public class LibraryUpdate {

        public static void main(String[] args) {

            LibraryEntity library = new LibraryEntity();
            library.setLibraryName("Central Library");
            library.setCity("Bangalore");
            library.setBooks(50000);

            EntityManagerFactory emf = null;
            EntityManager em = null;
            EntityTransaction et = null;


            try {
                emf = Persistence.createEntityManagerFactory("something");
                em = emf.createEntityManager();
                et = em.getTransaction();

                et.begin();

                  LibraryEntity entity = em.find(LibraryEntity.class, 1);
                System.out.println("Old data : " + entity);


                entity.setLibraryName("State Central Library");
                entity.setCity("Hyderabad");
                entity.setBooks(60000);

                LibraryEntity updatedEntity = em.merge(entity);
                System.out.println("Updated data : " + updatedEntity);

                et.commit();
                System.out.println("Library data updated successfully");

            } catch (PersistenceException e) {
                e.printStackTrace();
                if (et != null) {
                    et.rollback();
                }
            } finally {
                if (em != null) {
                    em.close();
                }
                if (emf != null) {
                    emf.close();
                }
            }
        }
    }
