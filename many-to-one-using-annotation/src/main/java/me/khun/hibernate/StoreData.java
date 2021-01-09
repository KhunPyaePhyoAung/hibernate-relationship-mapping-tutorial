package me.khun.hibernate;

import me.khun.hibernate.entity.Company;
import me.khun.hibernate.entity.Employee;
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

        Company company = new Company();
        company.setName("Alphasoft");
        company.setType("IT");

        Employee employee1 = new Employee();
        employee1.setName("Khun Pyae Phyo Aung");
        employee1.setEmail("khunpyaephyo@gmail.com");
        employee1.setCompany(company);

        Employee employee2 = new Employee();
        employee2.setName("Khun Lar Lay");
        employee2.setEmail("larlay@gmail.com");
        employee2.setCompany(company);

        session.persist(employee1);
        session.persist(employee2);

        transaction.commit();
        session.close();
        System.out.println("Success");
    }
}
