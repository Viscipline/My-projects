package com.howtodoinjava.hibernate.test.dto.practical_project;

import com.howtodoinjava.hibernate.test.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class MainLibrary {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your option [1-12]");
        System.out.println("1 : Insert author");
        System.out.println("2 : Insert book");
        System.out.println("3 : Insert publishing house");
        System.out.println("4 : Associate some authors to a book");
        System.out.println("5 : Associate some books to a publishing house");
        System.out.println("6 : Display a specific author");
        System.out.println("7 : Display a specific book");
        System.out.println("8 : Display a specific publishing house");
        System.out.println("9 : The list of all authors");
        System.out.println("10 : The list of all books");
        System.out.println("11 : The list of all publishing houses");
        System.out.println("12 : The name and the age of all authors who wrote a specific book");
        System.out.println("13 : The publishing house and the title of the books of a certain genre");
        System.out.println("14 : The oldest book and its authors with their years of experience");
        System.out.println("15 : The newest book and its authors with their years of experience");
        System.out.println("16 : Check the status of a specific book");
        System.out.println("17 : Update author");
        System.out.println("18 : Update book");
        System.out.println("19 : Update publishing house");
        System.out.println("20 : Delete a specific author");
        System.out.println("21 : Delete a specific book");
        System.out.println("22 : Delete a specific publishing house");

        int option = scanner.nextInt();

        do {
            // Insert author
            if (option == 1) {
                System.out.println("Insert the surname");
                scanner.nextLine();
                String input = scanner.nextLine();
                System.out.println("Insert the name");
                String input2 = scanner.nextLine();
                System.out.println("Insert the age");
                Integer input3 = scanner.nextInt();
                System.out.println("Insert the years of experience");
                Integer input4 = scanner.nextInt();
                System.out.println("Insert the books genre");
                scanner.nextLine();
                String input5 = scanner.nextLine();

                Authors author = new Authors();
                author.setSurname(input);
                author.setName(input2);
                author.setAge(input3);
                author.setYearsOfExperience(input4);
                author.setBooksGenre(input5);

                System.out.println("The author has been successfully added!");
                session.persist(author);
            }
            // Insert book
            if (option == 2) {
                System.out.println("Insert book title");
                scanner.nextLine();
                String input = scanner.nextLine();
                System.out.println("Insert year of publication");
                Integer input2 = scanner.nextInt();
                System.out.println("Insert the genre");
                scanner.nextLine();
                String input3 = scanner.nextLine();
                System.out.println("Insert the number of pages");
                Integer input4 = scanner.nextInt();
                System.out.println("Insert the status");
                scanner.nextLine();
                String input5 = scanner.nextLine();

                Books books = new Books();
                books.setTitle(input);
                books.setYearOfPublication(input2);
                books.setGenre(input3);
                books.setNumberOfPages(input4);
                books.setStatus(input5);
                session.persist(books);
                System.out.println("The author has been successfully added");

            }
            // Insert publishing house
            if (option == 3) {
                System.out.println("Insert the name of the publishing house");
                String input = scanner.nextLine();
                System.out.println("Insert the year of appearance");
                Integer input1 = scanner.nextInt();
                System.out.println("Insert the ranking");
                Integer input2 = scanner.nextInt();

                PublishingHouses publishingHouses = new PublishingHouses();
                publishingHouses.setName(input);
                publishingHouses.setYearOfAppearance(input1);
                publishingHouses.setRanking(input2);
                session.persist(publishingHouses);
                System.out.println("The publishing house has been successfully added");

                System.out.println("Choose another option [1-12]");
                option = scanner.nextInt();
            }
            //Associate some authors to a book
            if (option == 4) {
                System.out.println("Insert the name of the book to which you want to add an author");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From Books where title =: t");
                query.setParameter("t", input);


                System.out.println("Insert the surname of the author who contributed to the writing of the book");
                String input2 = scanner.nextLine();

                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                Books books = (Books) o;


                Query query1 = session.createQuery("From Authors where surname =: sur");
                query1.setParameter("sur", input2);

                List list1 = ((org.hibernate.query.Query<?>) query1).list();
                Object o1 = list1.get(0);
                Authors a = (Authors) o1;

                books.getAuthorsList().add(a);
                session.update(books);
                System.out.println("Press 0 to save");
                System.out.println("The author has been successfully added to the book");
            }
            // Associate some books to a publishing house
            if (option == 5) {
                System.out.println("Insert the name of the publishing house" +
                        " to which you want to add a book");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("from PublishingHouses where name =:n");
                query.setParameter("n", input);

                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                PublishingHouses p = (PublishingHouses) o;

                System.out.println("Insert the title of the book");
                String input2 = scanner.nextLine();

                Query query1 = session.createQuery("from Books where title =:t");
                query1.setParameter("t", input2);

                List list2 = ((org.hibernate.query.Query<?>) query1).list();
                Object o2 = list2.get(0);
                Books c = (Books) o2;
                p.setBooks(c);

                session.update(p);
                System.out.println("Press 0 to save");
            }
            // Display a specific author
            if (option == 6) {
                System.out.println("Insert the surname of the author who you wish to display");
                scanner.nextLine();
                String input = scanner.nextLine();

                System.out.println("Insert the name of the author who you wish to display");
                String input1 = scanner.nextLine();

                Query query = session.createQuery("From Authors where surname =:sur and name =:n");
                query.setParameter("sur", input);
                query.setParameter("n", input1);
                List<?> list = ((org.hibernate.query.Query<?>) query).list();
                System.out.println("The author is displaying...");
                System.out.println(list);
            }
            // Display a specific book
            if (option == 7){
                System.out.println("Insert the title of the book which you wish to display");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From Books where title =:t");
                query.setParameter("t", input);
                List<?> list = ((org.hibernate.query.Query<?>) query).list();
                System.out.println("The book is displaying...");
                System.out.println(list);
            }
            // Display a specific publishing house
            if (option == 8){
                System.out.println("Insert the name of the publishing house which you wish to display");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From PublishingHouses where name =:n");
                query.setParameter("n", input);
                List<?> list = ((org.hibernate.query.Query<?>) query).list();
                System.out.println("The publishing house is displaying...");
                System.out.println(list);
            }
            // The list of all authors
            if (option == 9){
                Query query = session.createQuery("From Authors");
                List<?> list = ((org.hibernate.query.Query<?>) query).list();
                System.out.println("The list of all authors is being displayed");
                System.out.println(list);
            }
            // The list of all books
            if (option == 10){
                Query query = session.createQuery("From Books");
                List<?> list = ((org.hibernate.query.Query<?>) query).list();
                System.out.println("The list of all books is being displayed");
                System.out.println(list);
            }
            // The list of all publishing houses
            if (option == 11){
                Query query = session.createQuery("From PublishingHouses");
                List<?> list = ((org.hibernate.query.Query<?>) query).list();
                System.out.println("The list of all publishing houses is being displayed");
                System.out.println(list);
            }
            // The name and the age of all authors who wrote a specific book
            if (option == 12) {
                System.out.println("Insert the title of the book");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("from Books where title =:t");
                query.setParameter("t", input);
                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                Books b = (Books) o;
                System.out.print("The name and the age of all authors who wrote the book: ");
                for (Authors authors : b.getAuthorsList()) {
                    System.out.println( authors.getName() + " - " + authors.getAge() + " years");
                }
            }
            // The publishing house and the title of the books of a certain genre
            if (option == 13) {
                System.out.println("Insert the genre");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("from Books where genre =:g");
                query.setParameter("g", input);

                Query query1 = session.createQuery("From PublishingHouses");

                List list = ((org.hibernate.query.Query<?>) query1).list();
                Object o = list.get(0);
                PublishingHouses p = (PublishingHouses) o;
                System.out.print("The publishing houses and the titles of the books : ");
                System.out.println(p.getName() + " - " + p.getBooks().getTitle());
            }
            // The oldest book and its authors with their years of experience
            if (option == 14) {
                Query query = session.createQuery("From Books order by yearOfPublication");

                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                Books b = (Books) o;
                System.out.print("The oldest book is : " + b.getTitle() + " and its authors with their years of experience: ");
                for (Authors authors : b.getAuthorsList()) {
                    System.out.println(authors.getName() + " - " + authors.getYearsOfExperience() + " years");
                }
            }
            // The newest book and its authors with their years of experience
            if (option == 15) {
                Query query = session.createQuery("From Books order by yearOfPublication desc");

                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                Books b = (Books) o;
                System.out.println("The newest book is : " + b.getTitle() + "and its authors with their years of experience: ");
                for (Authors authors : b.getAuthorsList()) {
                    System.out.println(authors.getName() + " - " + authors.getYearsOfExperience() + " years");
                }
            }
            // Check the status of a specific book
            if (option == 16) {
                System.out.println("Insert the title of the book");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From Books where title =:t");
                query.setParameter("t", input);

                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                Books b = (Books) o;
                System.out.println("The book is " + b.getStatus());
            }
            // Update autor
            if (option == 17) {
                System.out.println("Insert the surname of the author who you wish to update");
                scanner.nextLine();
                String input = scanner.nextLine();

                System.out.println("Insert the name of the author who you wish to update");
                String input1 = scanner.nextLine();

                Query query = session.createQuery("from Authors where surname =:sur and name =:n");
                query.setParameter("sur", input);
                query.setParameter("n", input1);

                System.out.println("Choose one option [1-5]");
                System.out.println("1 : Update the years of experience");
                System.out.println("2 : Update the books genre");
                System.out.println("3 : Update the surname");
                System.out.println("4 : Update the name");
                System.out.println("5 : Update the age");
                int input2 = scanner.nextInt();

                if (input2 == 1) {
                    System.out.println("Insert the new value");
                    Integer yearsOfExperience = scanner.nextInt();

                    List list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Authors a = (Authors) o;
                    a.setYearsOfExperience(yearsOfExperience);
                    session.update(a);
                }

                if (input2 == 2) {
                    System.out.println("Insert the new value");
                    scanner.nextLine();
                    String booksGenre = scanner.nextLine();

                    List<?> list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Authors a = (Authors) o;
                    a.setBooksGenre(booksGenre);
                    session.update(a);
                }

                if (input2 == 3) {
                    System.out.println("Insert the new value");
                    scanner.nextLine();
                    String surname = scanner.nextLine();

                    List<?> list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Authors a = (Authors) o;
                    a.setSurname(surname);
                    session.update(a);
                }

                if (input2 == 4) {
                    System.out.println("Insert the new value");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    List<?> list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Authors a = (Authors) o;
                    a.setName(name);
                    session.update(a);
                }

                if (input2 == 5) {
                    System.out.println("Insert the new value");
                    Integer age = scanner.nextInt();

                    List<?> list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Authors a = (Authors) o;
                    a.setAge(age);
                    session.update(a);
                }
                System.out.println("Press 0 to save");
            }
            // Update book
            if (option == 18) {
                System.out.println("Insert title of the book which you wish to update");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("from Books where title =:t");
                query.setParameter("t", input);

                System.out.println("Choose one option [1-5]");
                System.out.println("1 : Update the title");
                System.out.println("2 : Update the year of publication");
                System.out.println("3 : Update the genre");
                System.out.println("4 : Update the number of pages");
                System.out.println("5 : Update the status");
                int input2 = scanner.nextInt();

                if (input2 == 1) {
                    System.out.println("Insert the new value");
                    scanner.nextLine();
                    String title = scanner.nextLine();

                    List list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Books b = (Books) o;
                    b.setTitle(title);
                    session.update(b);
                }

                if (input2 == 2) {
                    System.out.println("Insert the new value");
                    Integer yearOfPublication = scanner.nextInt();

                    List<?> list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Books b = (Books) o;
                    b.setYearOfPublication(yearOfPublication);
                    session.update(b);
                }

                if (input2 == 3) {
                    System.out.println("Insert the new value");
                    scanner.nextLine();
                    String genre = scanner.nextLine();

                    List<?> list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Books b = (Books) o;
                    b.setGenre(genre);
                    session.update(b);
                }

                if (input2 == 4) {
                    System.out.println("Insert the new value");
                    Integer numberOfPages = scanner.nextInt();

                    List<?> list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Books b = (Books) o;
                    b.setNumberOfPages(numberOfPages);
                    session.update(b);
                }

                if (input2 == 5) {
                    System.out.println("Insert the new value");
                    scanner.nextLine();
                    String status = scanner.nextLine();

                    List<?> list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    Books b = (Books) o;
                    b.setStatus(status);
                    session.update(b);
                }
                System.out.println("Press 0 to save");
            }
            // Update publishing house
            if (option == 19) {
                System.out.println("Insert the name of the publishing house which you wish to update");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("from PublishingHouses where name =:n");
                query.setParameter("n", input);

                System.out.println("Choose one option [1-4]");
                System.out.println("1 : Update the year of appearance");
                System.out.println("2 : Update the name");
                System.out.println("3 : Update the ranking");
                int input2 = scanner.nextInt();

                if (input2 == 1) {
                    System.out.println("Insert the new value");
                    Integer yearOfAppearance = scanner.nextInt();

                    List list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    PublishingHouses p = (PublishingHouses) o;
                    p.setYearOfAppearance(yearOfAppearance);
                    session.update(p);
                }

                if (input2 == 2) {
                    System.out.println("Insert the new value");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    List list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    PublishingHouses p = (PublishingHouses) o;
                    p.setName(name);
                    session.update(p);
                }

                if (input2 == 3) {
                    System.out.println("Insert the new value");
                    Integer ranking = scanner.nextInt();

                    List list = ((org.hibernate.query.Query<?>) query).list();
                    Object o = list.get(0);
                    PublishingHouses p = (PublishingHouses) o;
                    p.setRanking(ranking);
                    session.update(p);
                }
                System.out.println("Press 0 to save");
            }
            // Delete a specific author
            if (option == 20){
                System.out.println("Insert the surname of the author who you wish to delete");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From Author where surname =:sur");
                query.setParameter("sur", input);

                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                Authors a = (Authors) o;

                session.delete(a);
                System.out.println("Press 0 to save");
                System.out.println("The author has been deleted");
            }
            // Delete a specific book
            if (option == 21){
                System.out.println("Insert the title of the book which you wish to delete");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From Books where title =:t");
                query.setParameter("t", input);

                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                Books b = (Books) o;

                session.delete(b);
                System.out.println("Press 0 to save");
                System.out.println("The book has been deleted");
            }
            // sterge editura
            if (option == 22) {
                System.out.println("Insert the name of the publishing house which you wish to delete");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From PublishingHouses where name =:n");
                query.setParameter("n", input);

                List list = ((org.hibernate.query.Query<?>) query).list();
                Object o = list.get(0);
                PublishingHouses p = (PublishingHouses) o;

                session.delete(p);
                System.out.println("Press 0 to save");
                System.out.println("The publishing house has been deleted");
            }
            System.out.println("Choose another option [1-12]");
            option = scanner.nextInt();

        } while (option > 0 && option < 23);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
