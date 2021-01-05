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
        tag1.setName("programming");

        Tag tag2 = new Tag();
        tag2.setName("java");

        Tag tag3 = new Tag();
        tag3.setName("language");

        Tag tag4 = new Tag();
        tag4.setName("javascript");

        Tag tag5 = new Tag();
        tag5.setName("differences");

        List<Tag> tagList1 = new ArrayList<>();
        tagList1.add(tag1);
        tagList1.add(tag2);
        tagList1.add(tag3);

        List<Tag> tagList2 = new ArrayList<>();
        tagList2.add(tag1);
        tagList2.add(tag2);
        tagList2.add(tag3);
        tagList2.add(tag4);
        tagList2.add(tag5);

        Post post1 = new Post();
        post1.setContent("Java is a programming language.");
        post1.setTags(tagList1);

        Post post2 = new Post();
        post2.setContent("What are the differences between Java and JavaScript programming languages?");
        post2.setTags(tagList2);

        session.persist(post1);
        session.persist(post2);

        transaction.commit();
        session.close();
        System.out.println("Success");
    }
}
