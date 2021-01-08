package me.khun.hibernate;

import me.khun.hibernate.entity.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.List;

public class FetchLaptop {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        TypedQuery<Laptop> typedQuery = session.createQuery("from Laptop");
        List<Laptop> laptopList = typedQuery.getResultList();

        for ( Laptop laptop : laptopList ) {
            System.out.println( "Laptop -> Brand : " + laptop.getBrand() );
        }

        session.close();

    }
}
