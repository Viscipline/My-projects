package com.howtodoinjava.hibernate.test.dto.practical_project;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "Books")
public class Books {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column ( name = "BookID")
    private Integer id;
    @Column ( name = "Title", nullable = false, unique = true)
    private String title;
    @Column ( name = "YearOfPublication", nullable = false)
    private Integer yearOfPublication;
    @Column ( name = "Genre", nullable = false)
    private String genre;
    @Column ( name = "NumberOfPages", nullable = false)
    private Integer numberOfPages;
    @Column ( name = "Status", nullable = false)
    private String status;
    @OneToMany
    private List<Authors> authorsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Authors> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Authors> authorsList) {
        this.authorsList = authorsList;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", genre='" + genre + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", status='" + status + '\'' +
                ", authorsList=" + authorsList +
                '}';
    }
}

