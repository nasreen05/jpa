package com.xworkz.library.runner;


import com.xworkz.library.entity.LibraryEntity;
import javax.persistence.*;

public class LibraryRunner {

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
            em.persist(library);
            et.commit();

            System.out.println("Library data inserted");

        } catch (PersistenceException e) {
            e.printStackTrace();
            if (et != null) et.rollback();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
