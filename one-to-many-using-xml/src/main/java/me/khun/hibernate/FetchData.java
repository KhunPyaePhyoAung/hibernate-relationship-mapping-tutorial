package me.khun.hibernate;

import me.khun.hibernate.entity.Answer;
import me.khun.hibernate.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.List;

public class FetchData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        TypedQuery<Question> typedQuery = session.createQuery("from Question");
        List<Question> questionList = typedQuery.getResultList();
        for(Question question : questionList){
            String questionBody = question.getQuestionBody();
            List<Answer> answerList = question.getAnswers();
            System.out.println("Question : "+questionBody);
            for(int i = 0; i < answerList.size(); i++){
                Answer answer = answerList.get(i);
                System.out.printf("%d) %s (Posted By : %s)%n", i+1, answer.getAnswerBody(), answer.getPostedBy());
            }
        }
        session.close();
    }
}
