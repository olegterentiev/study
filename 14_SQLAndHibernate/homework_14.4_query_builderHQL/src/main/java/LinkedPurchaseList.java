import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LinkedPurchaseList")
@IdClass(LinkedPurchaseList.Id.class)
public class LinkedPurchaseList {

    public LinkedPurchaseList(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
    public LinkedPurchaseList() {
    }
    @javax.persistence.Id
    @Column(name = "student_id")
    private Integer studentId;

    @javax.persistence.Id
    @Column(name = "course_id")
    private Integer courseId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public static class Id implements Serializable {
        public Id(Integer studentId, Integer courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }
        public Id() {
        }
        private Integer studentId;
        private Integer courseId;
        public Integer getStudentId() {
            return studentId;
        }
        public void setStudentId(Integer studentId) {
            this.studentId = studentId;
        }
        public Integer getCourseId() {
            return courseId;
        }
        public void setCourseId(Integer courseId) {
            this.courseId = courseId;
        }
    }
}
