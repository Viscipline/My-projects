package com.howtodoinjava.hibernate.test.dto.practical_project;

import jakarta.persistence.*;

@Entity
@Table (name = "Authors")
public class Authors {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "AuthorID")
    private Integer id;
    @Column ( name = "Surname", nullable = false, unique = true)
    private String surname;
    @Column ( name = "Name", nullable = false)
    private String name;
    @Column ( name = "Age", nullable = false)
    private Integer age;
    @Column ( name = "YearsOfExperience", nullable = false)
    private Integer yearsOfExperience;
    @Column ( name = "BooksGenre", nullable = false)
    private String booksGenre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getBooksGenre() {
        return booksGenre;
    }

    public void setBooksGenre(String booksGenre) {
        this.booksGenre = booksGenre;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + yearsOfExperience +
                ", booksGenre='" + booksGenre + '\'' +
                '}';
    }
}
