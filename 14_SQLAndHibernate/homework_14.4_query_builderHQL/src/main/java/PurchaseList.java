import javax.persistence.*;
import java.util.Date;

@Entity
public class PurchaseList {

//    public PurchaseList(String studentName, String courseName) {
//        this.studentName = studentName;
//        this.courseName = courseName;
//    }

    public PurchaseListKey getId() {
        return id;
    }

    public void setId(PurchaseListKey id) {
        this.id = id;
    }

    @EmbeddedId
    private PurchaseListKey id;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String toString(){
        return String.valueOf(this.id);
    }
}
