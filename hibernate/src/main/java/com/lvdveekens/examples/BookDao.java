package com.lvdveekens.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookDao {

    private SessionFactory sessionFactory;

    private void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private void exit() {
        sessionFactory.close();
    }

    private void insert(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(book);

        session.getTransaction().commit();
        session.close();
    }

    private Book findById(long id) {
        Session session = sessionFactory.openSession();

        Book book = session.get(Book.class, id);

        session.close();
        return book;
    }

    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        bookDao.setup();

//        Book book = new Book();
//        book.setTitle("Clean Code");
//        book.setAuthor("Robert Martin");
//        book.setPrice(39.99f);
//
//        bookDao.insert(book);

        Book cleanCode = bookDao.findById(2);
        System.out.println("Title : " + cleanCode.getTitle());
        System.out.println("Author: " + cleanCode.getAuthor());
        System.out.println("Price : " + cleanCode.getPrice());

        bookDao.exit();
    }

}
