package com.xworkz.movies.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString

@Table(name="Movie_info")
public class MoviesEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Movie_id")
    private  int movie_id;

    @Column(name="title")
    private  String title;

    @Column(name="director")
    private  String director;

    @Column(name="genre")
    private String genre;


    @Column(name="release_Year")
    private int releaseYear;



}
