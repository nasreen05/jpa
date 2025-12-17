package com.xworkz.movies.runner;

import com.xworkz.movies.entity.MoviesEntity;

import javax.persistence.*;

public class MovieUpdate {

    public static void main(String[] args) {

        MoviesEntity firstMovie = new MoviesEntity();
        firstMovie.setTitle("Inception");
        firstMovie.setDirector("Christopher Nolan");
        firstMovie.setGenre("Science fiction");
        firstMovie.setReleaseYear(2010);


        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("something");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            // Find existing movie by ID (change ID if needed)
            MoviesEntity entity = em.find(MoviesEntity.class, 1);
            System.out.println("Old data : " + entity);

            // Update movie details
            entity.setTitle("Inception");
            entity.setDirector("Christopher Nolan");
            entity.setGenre("Sci-Fi Thriller");
            entity.setReleaseYear(2010);

            MoviesEntity updatedEntity = em.merge(entity);
            System.out.println("Updated data : " + updatedEntity);

            et.commit();
            System.out.println("Movie data updated successfully");

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
