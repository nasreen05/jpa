package com.xworkz.novel.entity;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "novels")
@NamedQuery(name = "findAllNovelEntities", query = "SELECT n FROM NovelEntity n")
public class NovelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "novel_id")
    private int novelId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private double price;

    @Column(name = "pages")
    private int pages;

    @Column(name = "published_year")
    private String publishedYear;
}
