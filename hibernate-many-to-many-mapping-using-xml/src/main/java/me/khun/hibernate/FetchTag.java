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

public class FetchTag {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        TypedQuery<Tag> typedQuery = session.createQuery("from Tag");
        List<Tag> tagList = typedQuery.getResultList();

        for(Tag tag : tagList){
            System.out.println("Tag : "+tag.getName());
            List<Post> postList = tag.getPosts();
            for(int i = 0; i < postList.size(); i++){
                Post post = postList.get(i);
                System.out.printf("%d) %s%n", i+1, post.getContent());
            }
            System.out.println();
        }
        session.close();
    }
}
