package me.khun.hibernate;

import me.khun.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.List;

public class FetchEmployee {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        TypedQuery<Employee> typedQuery = session.createQuery("from Employee");
        List<Employee> employeeList = typedQuery.getResultList();

        for (Employee employee : employeeList){
            System.out.printf("Employee -> Id : %d, Name : %s, Email : %s, Company Name : %s, Company Type : %s%n", employee.getId(), employee.getName(), employee.getEmail(), employee.getCompany().getName(), employee.getCompany().getType());
        }
        session.close();
    }
}
