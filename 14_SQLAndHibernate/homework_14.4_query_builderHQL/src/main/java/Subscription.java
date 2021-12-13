import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    public Subscription(int id, Student student, Course course, Date subscriptionDate) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.subscriptionDate = subscriptionDate;
    }
    public Subscription() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}