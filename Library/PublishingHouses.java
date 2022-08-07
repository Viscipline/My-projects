package com.howtodoinjava.hibernate.test.dto.practical_project;

import jakarta.persistence.*;

@Entity
@Table(name = "PublishingHouses")

public class PublishingHouses {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name = "PublishingHouseID")
    private Integer id;

    @Column ( name = "Name", nullable = false, unique = true)
    private String name;

    @Column ( name = "YearOfAppearance", nullable = false)
    private Integer yearOfAppearance;

    @Column ( name = "Ranking", nullable = false)
    private Integer ranking;

    @OneToOne
    private Books books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfAppearance() {
        return yearOfAppearance;
    }

    public void setYearOfAppearance(Integer yearOfAppearance) {
        this.yearOfAppearance = yearOfAppearance;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "PublishingHouses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfAppearance=" + yearOfAppearance +
                ", ranking=" + ranking +
                ", books=" + books +
                '}';
    }
}
