package com.lvdveekens.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PersonRepository {

    private SessionFactory sessionFactory;

    private void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            System.out.println(ex);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private void exit() {
        sessionFactory.close();
    }

    private void save(Person person) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(person);

        session.getTransaction().commit();
        session.close();
    }

    private Person findById(long id) {
        Session session = sessionFactory.openSession();

        Person person = session.get(Person.class, id);

        session.close();
        return person;
    }

    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        personRepository.setup();


        Person person = new Person();
        person.setName("Luciano van der Veekens");
        personRepository.save(person);

//        Person person = personRepository.findById(2);
//        System.out.println("Name : " + person.getName());
//        System.out.println("ID: " + person.getId());

        personRepository.exit();
    }

}
