package me.khun.hibernate;

import me.khun.hibernate.entity.Answer;
import me.khun.hibernate.entity.Question;
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

        Answer answer1 = new Answer();
        answer1.setAnswerBody("Java is a programming language.");
        answer1.setPostedBy("John");

        Answer answer2 = new Answer();
        answer2.setAnswerBody("Java is a platform.");
        answer2.setPostedBy("Angle");

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(answer1);
        answerList1.add(answer2);

        Question question1 = new Question();
        question1.setQuestionBody("What is java?");
        question1.setAnswers(answerList1);

        Answer answer3 = new Answer();
        answer3.setAnswerBody("Servlet is an API.");
        answer3.setPostedBy("David");

        Answer answer4 = new Answer();
        answer4.setAnswerBody("Servlet is an interface.");
        answer4.setPostedBy("Mata");

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(answer3);
        answerList2.add(answer4);

        Question question2 = new Question();
        question2.setQuestionBody("What is servlet?");
        question2.setAnswers(answerList2);

        session.persist(question1);
        session.persist(question2);

        transaction.commit();
        session.close();
        System.out.println("Success");
    }
}
