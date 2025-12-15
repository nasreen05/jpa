package com.xworkz.library.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Setter
@Getter
@ToString
@Entity
@Table(name = "library_info")
public class LibraryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private int libraryId;


    @Column(name = "library_name")
    private String libraryName;


    @Column(name = "city")
    private String city;


    @Column(name = "books")
    private int books;
}