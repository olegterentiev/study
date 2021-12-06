import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<String> studentName = new ArrayList<>();
        List<PurchaseList> list = session.createQuery("FROM PurchaseList").getResultList();

        for (PurchaseList l1: list) {
            String name = l1.getStudentName();
            studentName.add(name);
        }

        for (String l2 : studentName) {
            Query studentIdQuery = session.createQuery("select id FROM Student WHERE name = :param");
            Query courseNameQuery = session.createQuery("select courseName FROM PurchaseList WHERE studentName = :param");
            studentIdQuery.setParameter("param" , l2);
            courseNameQuery.setParameter("param" , l2);
            int studentId = (int) studentIdQuery.getSingleResult();
//            System.out.println(studentId);
            String courseName = String.valueOf(courseNameQuery.getSingleResult());
//            System.out.println(courseName);
            Query courseId = session.createQuery("select id FROM Course WHERE name = :param");
            courseId.setParameter("param", courseName);
            int courId = (int) courseId.getSingleResult();
            LinkedPurchaseList test = new LinkedPurchaseList(studentId,courId);
            System.out.println(test);
            session.saveOrUpdate(test);
        }

        transaction.commit();
        sessionFactory.close();
    }
}

