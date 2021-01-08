package me.khun.hibernate;

import me.khun.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.List;

public class FetchPerson {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        TypedQuery<Person> typedQuery = session.createQuery("from Person");
        List<Person> personList = typedQuery.getResultList();

        for(Person person : personList){
            System.out.printf("Person -> Id : %d, Name : %s, Age : %d, Laptop Id : %d, Laptop Brand : %s%n", person.getId(), person.getName(), person.getAge(), person.getLaptop().getId(), person.getLaptop().getBrand());
        }
        session.close();
    }
}
