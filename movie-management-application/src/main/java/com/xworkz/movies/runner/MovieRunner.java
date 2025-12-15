package com.xworkz.movies.runner;

import com.xworkz.movies.entity.MoviesEntity;

import javax.persistence.*;

public class MovieRunner {
    public static void main(String[] args) {
        MoviesEntity firstMovie = new MoviesEntity();
        firstMovie.setTitle("Inception");
        firstMovie.setDirector("Christopher Nolan");
        firstMovie.setGenre("Science fiction");
        firstMovie.setReleaseYear(2010);


        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;



        try{
        emf = Persistence.createEntityManagerFactory("something");
        System.out.println("EntityManagerFactory create : " + emf);
        em = emf.createEntityManager(); // DML insert, update, delete, DQL select
        et = em.getTransaction();
        et.begin();  // set auto commit to false
        // DML insert , update , delete , DQL select
        em.persist(firstMovie);
        System.out.println("Movie date inserted");
        et.commit();
    } catch (PersistenceException e) {
            e.printStackTrace();
            et.rollback();
        }finally {
            if(emf !=null){
                emf.close();}
            if(em!=null){
                em.close();

            }
        }


    }
}
