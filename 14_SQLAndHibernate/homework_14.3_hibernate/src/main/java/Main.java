import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Subscription subscription = session.get(Subscription.class, new SubscriptionKey(2,1));
        System.out.println(subscription.getSubscriptionDate());

        PurchaseList purchaseList = session.get(PurchaseList.class, new PurchaseListKey("Жариков Афанасий", "Веб-разработчик c 0 до PRO"));
        System.out.println(purchaseList.getSubscriptionDate());

        Student student = session.get(Student.class,1);
        System.out.println(student.getName() + "   " + student.getAge() );

        Teacher teacher = session.get(Teacher.class, 1);
        System.out.println(teacher.getName() + teacher.getSalary());

        Course course = session.get(Course.class, 1);
        System.out.println(course.getStudents().get(1).getName());

        List<Student> studentList = course.getStudents();
        for(Student student1 : studentList){
            System.out.println(student1.getName());
        }
        sessionFactory.close();
    }
}

