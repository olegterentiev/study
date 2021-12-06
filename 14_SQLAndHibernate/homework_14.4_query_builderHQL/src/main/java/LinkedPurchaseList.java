import javax.persistence.*;

@Entity
public class LinkedPurchaseList {

    public LinkedPurchaseList(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @EmbeddedId

        private LinkedPurchaseListKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    public LinkedPurchaseListKey getId() {
        return id;
    }

    public void setId(LinkedPurchaseListKey id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String toString(){
        return "student_id " + this.studentId + "\tcourse_id " + this.courseId;
    }
}
