
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompositeKey implements Serializable {

    public CompositeKey(String student, String course) {
        this.student = student;
        this.course = course;
    }
    public CompositeKey() {
    }

    @Column(name = "student_name")
    private String student;

    @Column(name = "course_name")
    private String course;

    String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeKey)) return false;
        CompositeKey compositeKey = (CompositeKey) o;
        return Objects.equals(getStudent(), compositeKey.getStudent()) &&
                Objects.equals(getCourse(), compositeKey.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudent(), getCourse());
    }

    public String toString(){
        return this.student + this.course;
    }
    
}
