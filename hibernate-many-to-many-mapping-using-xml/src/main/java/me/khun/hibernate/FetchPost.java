package me.khun.hibernate;

import me.khun.hibernate.entity.Post;
import me.khun.hibernate.entity.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.List;

public class FetchPost {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        TypedQuery<Post> typedQuery = session.createQuery("from Post");
        List<Post> postList = typedQuery.getResultList();

        for (Post post : postList){
            System.out.println("Post : "+post.getContent());
            List<Tag> tagList = post.getTags();
            for (Tag tag : tagList){
                System.out.print(":"+tag.getName());
            }
            System.out.println();
        }
        session.close();
    }
}
