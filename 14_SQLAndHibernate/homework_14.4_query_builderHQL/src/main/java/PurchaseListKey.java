import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseListKey implements Serializable {

    public PurchaseListKey(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public PurchaseListKey() {
    }

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseListKey)) return false;
        PurchaseListKey purchaseListKey = (PurchaseListKey) o;
        return Objects.equals(getStudentName(), purchaseListKey.getStudentName()) &&
                Objects.equals(getCourseName(), purchaseListKey.getCourseName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentName(), getCourseName());
    }

    public String toString(){
        return this.studentName + this.courseName;
    }
}
