package me.khun.hibernate;

import me.khun.hibernate.entity.Laptop;
import me.khun.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Laptop laptop1 = new Laptop();
        laptop1.setBrand("Dell");
        laptop1.setDescription("Dell i5 5th gen");

        Person person1 = new Person();
        person1.setName("Khun Pyae Phyo Aung");
        person1.setAge(22);
        person1.setLaptop(laptop1);

        Laptop laptop2 = new Laptop();
        laptop2.setBrand("ASUS");
        laptop2.setDescription("ASUS i7 10th gen gaming laptop");

        Person person2 = new Person();
        person2.setName("Khun Lar Lay");
        person2.setAge(20);
        person2.setLaptop(laptop2);

        Laptop laptop3 = new Laptop();
        laptop3.setBrand("MacBook");
        laptop3.setDescription("Think again");

        session.persist(person1);
        session.persist(laptop3);
        session.persist(person2);

        transaction.commit();
        session.close();
        System.out.println("Success");
    }
}
