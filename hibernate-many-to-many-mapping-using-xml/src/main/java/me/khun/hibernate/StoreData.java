package me.khun.hibernate;

import me.khun.hibernate.entity.Post;
import me.khun.hibernate.entity.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Tag tag1 = new Tag();
        tag1.setName("java");

        Tag tag2 = new Tag();
        tag2.setName("programming");

        List<Tag> tagList1 = new ArrayList<>();
        tagList1.add(tag1);
        tagList1.add(tag2);

        Post post1 = new Post();
        post1.setContent("What is java programming?");
        post1.setTags(tagList1);

        Tag tag3 = new Tag();
        tag3.setName("javascript");

        Tag tag4 = new Tag();
        tag4.setName("differences");

        List<Tag> tagList2 = new ArrayList<>();
        tagList2.add(tag1);
        tagList2.add(tag2);
        tagList2.add(tag3);
        tagList2.add(tag4);

        Post post2 = new Post();
        post2.setContent("What are the differences between Java programming and JavaScript programming?");
        post2.setTags(tagList2);

        session.persist(post1);
        session.persist(post2);

        transaction.commit();
        session.close();
        System.out.println("Success");
    }
}
