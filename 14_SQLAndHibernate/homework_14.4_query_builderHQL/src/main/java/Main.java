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
            Query studentId = session.createQuery("select id FROM Student WHERE name = :param");
            Query courseName = session.createQuery("select courseName FROM PurchaseListKey WHERE studentName = :param");
            studentId.setParameter("param" , l2);
            courseName.setParameter("param" , l2);
            int rrr = (int) studentId.getSingleResult();
            System.out.println(rrr);
            String course = String.valueOf(courseName.getSingleResult());
            System.out.println(course);
            Query courseId = session.createQuery("select id FROM Course WHERE name = :param");
            courseId.setParameter("param", course);
            int courId = (int) courseId.getSingleResult();
            LinkedPurchaseList test = new LinkedPurchaseList(rrr,courId);
            System.out.println(test);
            session.saveOrUpdate(test);
        }

        transaction.commit();
        sessionFactory.close();
    }
}

